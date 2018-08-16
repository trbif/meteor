package cn.meteor.cloud.train;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.dubbo.NewsConsumerService;
import cn.meteor.cloud.service.W2VModelService;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.data.train.starter
 * @ClassName: ${TYPE_NAME}
 * @Description: 定时训练器
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 14:15
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 14:15
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
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

    private final static long TWO_WEEKS_IN_MS = 1000*60*60*24*14;

    public void train(){
        if(! new File(modeldir).exists()){
            new File(modeldir).mkdirs();
        }
        List<Word> initWords = WordSegmenter.seg("这里用作初始化word分词器");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        long currentMS = Calendar.getInstance().getTimeInMillis();
        List<NewsBean> beanList = newsConsumerService.getNewsList(currentMS-TWO_WEEKS_IN_MS,currentMS);
        Future future = fixedThreadPool.submit(new W2VTrainer(beanList,
                modeldir+"test.mod",
                new W2VParams.Builder().setVectorDim(20).build()));
        fixedThreadPool.shutdown();
        try {
            LOG.info("msg: {}",future.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
