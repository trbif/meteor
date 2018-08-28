package cn.meteor.centauri.alpha.train;

import cn.meteor.centauri.alpha.bean.W2VModelBean;
import cn.meteor.centauri.alpha.service.W2VModelService;
import cn.meteor.spacecraft.bean.CategoryBean;
import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.dubbo.NewsConsumerService;
import com.alibaba.fastjson.JSON;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: data-provider
 * @Description: 定时训练器
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 14:15
 * @Version: 1.0.0
 */
@Component
public class DataTrainStarter {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${w2v.modeldir}")
    private String modeldir;
    @Value("${w2v.modelversion}")
    private String modelversion;

    @Autowired
    NewsConsumerService newsConsumerService;
    @Autowired
    W2VModelService w2VModelService;
    @Autowired
    W2VProvider w2VProvider;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String LOCK = "task-job-lock";

    private static final String KEY = "tasklock";


//    final ReentrantLock lock = new ReentrantLock();

    private int[] dim = {10,20,50,70};

    private final static long TWO_WEEKS_IN_MS = 1000*60*60*24*14;

    public static List<CategoryBean> CATEGORY_LIST = new ArrayList<>();

//    @Scheduled(cron = "0 0/5 * * * ?")
    public void train(){
        boolean lock = false;
        lock = redisTemplate.opsForValue().setIfAbsent(KEY, LOCK);
        LOG.info("是否获取到锁:"+lock);
        try{
            if(lock){
                LOG.info("获取到锁，执行任务!");
                if(! new File(modeldir).exists()){
                    new File(modeldir).mkdirs();
                }
                CATEGORY_LIST.clear();
                CATEGORY_LIST = newsConsumerService.getAllCategories();
                List<Word> initWords = WordSegmenter.seg("这里用作初始化word分词器");
                ExecutorService fixedThreadPool = Executors.newFixedThreadPool(dim.length);
                long currentMS = Calendar.getInstance().getTimeInMillis();
                List<NewsBean> beanList = newsConsumerService.getNewsList(currentMS-TWO_WEEKS_IN_MS,currentMS);
                Map<W2VParams,Future> futureParams = new HashMap<>();
                for(int i=0;i<dim.length;i++){
                    W2VParams params = new W2VParams.Builder().setVectorDim(dim[i]).build();
                    futureParams.put(params,fixedThreadPool.submit(new W2VTrainer(beanList,
                            modeldir+currentMS+"_"+params.getVectorDim()+".mod",
                            params
                    )));
                }
                fixedThreadPool.shutdown();
                try {
                    for(Map.Entry futureParam:futureParams.entrySet()){
                        W2VParams params = (W2VParams)futureParam.getKey();
                        Future future = (Future)futureParam.getValue();
                        if(JSON.parseObject(future.get().toString()).get("errorMsg").equals("success")){
                            W2VModelBean w2VModelBean = new W2VModelBean();
                            w2VModelBean.setModelAccuracy(JSON.parseObject(future.get().toString()).getDouble("accuracy"));
                            w2VModelBean.setModelPublishDate(Calendar.getInstance().getTimeInMillis());
                            w2VModelBean.setModelVersion(modelversion);
                            w2VModelBean.setModelParams(params.toString());
                            w2VModelBean.setModelSatisfaction(0.0);
                            w2VModelBean.setModelName(JSON.parseObject(future.get().toString()).getString("modelName"));
                            LOG.info("新增W2VModelBean： {}",w2VModelBean);
                            w2VModelService.insert(w2VModelBean);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                w2VProvider.setCurrentModel();
            }else{
                LOG.info("没有获取到锁，不执行任务!");
                return;
            }
        }finally {// 无论如何，最终都要释放锁
            if (lock) {// 如果获取了锁，则释放锁
                redisTemplate.delete(KEY);
                LOG.info("任务结束，释放锁!");
            } else {
                LOG.info("没有获取到锁，无需释放锁!");
            }
        }
    }
}
