package cn.meteor.centauri.alpha.train;

import cn.meteor.centauri.alpha.bean.W2VModelBean;
import cn.meteor.centauri.alpha.service.W2VModelService;
import cn.meteor.centauri.alpha.train.rebuild.impl.UserVectorRebuild;
import cn.meteor.centauri.alpha.train.word2vec.vec.VectorModel;
import cn.meteor.centauri.alpha.workbox.annotation.TimeCosts;
import cn.meteor.spacecraft.dubbo.NewsConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ProjectName: data-provider
 * @Description: 向量重构入口类 一般在更换模型时执行
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 9:02
 * @Version: 1.0.0
 */
@Component
public class W2VProvider {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    W2VModelService w2VModelService;
    @Autowired
    NewsConsumerService newsConsumerService;

    private VectorModel currentModel;

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        W2VModelBean w2VModelBean = w2VModelService.getMostAccurateModel();
//        VectorModel model = VectorModel.loadFromFile(w2VModelBean.getModelName());
//        currentModel = model;
//        return super.postProcessAfterInitialization(bean, beanName);
//    }

    @TimeCosts(name="W2VProvider用户向量重构")
    public void userVectorRebuild(){
        W2VModelBean bean = w2VModelService.getMostAccurateModel();
        VectorModel newModel = VectorModel.loadFromFile(bean.getModelName());
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        List<Future> futureParams = new ArrayList<>();
        futureParams.add(fixedThreadPool.submit(new UserVectorRebuild(w2VModelService, newsConsumerService,currentModel,newModel)));

        fixedThreadPool.shutdown();
        while (true) {
            if (fixedThreadPool.isTerminated()) {
                //原本写计时方法，后用aop+annotation代替，有一定时间差，但影响不大
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @PostConstruct
    public void setCurrentModel(){
        W2VModelBean w2VModelBean = w2VModelService.getAvailableModel();
        VectorModel model = null;
        if(w2VModelBean!=null){
            model = VectorModel.loadFromFile(w2VModelBean.getModelName());
            w2VModelBean.setModelRecentUsedTime(Calendar.getInstance().getTimeInMillis());
            w2VModelService.updateRecentUsedTime(w2VModelBean);
        }
        currentModel = model;
    }

    public VectorModel getCurrentModel() {
        return currentModel;
    }
}
