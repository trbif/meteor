package cn.meteor.cloud.oper.impl;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.bean.UserVectorBean;
import cn.meteor.cloud.oper.UserOper;
import cn.meteor.cloud.returnmsg.ReturnMsg;
import cn.meteor.cloud.service.NewsService;
import cn.meteor.cloud.service.UserService;
import cn.meteor.cloud.train.W2VCalculator;
import cn.meteor.cloud.train.W2VProvider;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/20 10:59
 * @Version: 1.0.0
 */
@Component
public class UserOperImpl implements UserOper {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    W2VProvider w2VProvider;
    @Autowired
    UserService userService;

    @Override
    public ReturnMsg init(UserBean userBean){
        int vectorDim = w2VProvider.getCurrentModel().getVectorSize();
        Float[] userRandomVec = new Float[vectorDim];
        Random random = new Random();
        //词元向量随机生成
        for(int i=0; i<userRandomVec.length;i++) {
            userRandomVec[i] = (float)((random.nextFloat()-0.5)/vectorDim);
        }
        return userService.init(userBean,userRandomVec);
    }

    @Override
    public ReturnMsg dislike(UserBean userBean,NewsBean newsBean) {
        UserVectorBean userVectorBean = userService.getUserVectorBeanByUserid(userBean);
        List<Float> listStable = JSON.parseArray(userVectorBean.getStablevector(),Float.class);
        Float[] stableVector = listStable.toArray(new Float[listStable.size()]);
        float[] categoryVector = w2VProvider.getCurrentModel().getWordVector(newsBean.getNewsCategory());
        LOG.info("categoryVector:{}",categoryVector);
        if(categoryVector==null) return null;
        W2VCalculator.toOne(categoryVector);
        for(int i=0;i<categoryVector.length;i++){
            categoryVector[i] = 0-categoryVector[i];
        }
        W2VCalculator.vectorPlus(stableVector,categoryVector);
        userVectorBean.setStablevector(Arrays.asList(stableVector).toString());
        userVectorBean.setUserid(userBean.getId());
        userService.updateOrInsertUserVectorBean(userVectorBean);
        return null;
    }

    @Override
    public ReturnMsg like(UserBean userBean,NewsBean newsBean) {
        UserVectorBean userVectorBean = userService.getUserVectorBeanByUserid(userBean);
        List<Float> listStable = JSON.parseArray(userVectorBean.getStablevector(),Float.class);
        Float[] stableVector = listStable.toArray(new Float[listStable.size()]);
        float[] categoryVector = w2VProvider.getCurrentModel().getWordVector(newsBean.getNewsCategory());
        LOG.info("categoryVector:{}",categoryVector);
        if(categoryVector==null) return null;
        W2VCalculator.toOne(categoryVector);
        W2VCalculator.vectorPlus(stableVector,categoryVector);
        userVectorBean.setStablevector(Arrays.asList(stableVector).toString());
        userVectorBean.setUserid(userBean.getId());
        userService.updateOrInsertUserVectorBean(userVectorBean);
        return null;
    }

    @Override
    public List<NewsService> refresh(UserBean userBean) {
        return null;
    }
}
