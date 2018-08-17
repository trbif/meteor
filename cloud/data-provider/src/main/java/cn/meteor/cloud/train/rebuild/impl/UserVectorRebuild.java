package cn.meteor.cloud.train.rebuild.impl;

import cn.meteor.cloud.bean.CategoryBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.bean.UserVectorBean;
import cn.meteor.cloud.service.W2VModelService;
import cn.meteor.cloud.train.W2VCalculator;
import cn.meteor.cloud.train.rebuild.VectorRebuild;
import cn.meteor.cloud.train.word2vec.vec.VectorModel;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.train.rebuild
 * @ClassName: ${TYPE_NAME}
 * @Description: 线程执行期间应一边计算数据，一边更新数据库，这样jvm也就不会有大对象（一系列用户向量）的生成，因此选择将service资源下沉到线程中使用
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 10:09
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/17 10:09
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class UserVectorRebuild implements VectorRebuild {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private W2VModelService w2VModelService;
    private VectorModel oldModel;
    private VectorModel newModel;

    private UserVectorRebuild(){}
    public UserVectorRebuild(W2VModelService w2VModelService,VectorModel oldModel,VectorModel newModel){
        LOG.info("UserVectorRebuild初始化");
        this.w2VModelService = w2VModelService;
        this.oldModel = oldModel;
        this.newModel = newModel;
    }
    @Override
    public void rebuild() {
        long lastlogin = Calendar.getInstance().getTimeInMillis()-60*60*24*1000;
        List<CategoryBean> categoryBeans = w2VModelService.getAllCategory();
        LOG.info("所有分类信息：{}",categoryBeans);
        LOG.info("所有用户信息：{}",w2VModelService.arrangeUserList(1));
        for(UserBean userBean:w2VModelService.arrangeUserList(1)){
            //可优化点：采用有界队列或者别的结构维护少量数据而非全部加入treemap
            Map<Float,String> categoryScoreTreeMap = new TreeMap<>(new Comparator<Float>() {
                @Override
                public int compare(Float o1, Float o2) {
                    return o2.compareTo(o1);
                }
            });
            UserVectorBean userVectorBean = w2VModelService.getUserVectorByUserid(userBean.getId());
            LOG.info("userVectorBean：{}",userVectorBean);
            if(userVectorBean==null) continue;
            String stableVectorStr = userVectorBean.getStablevector();
            String currentVectorStr = userVectorBean.getCurrentvector();
            String intendedvectorStr = userVectorBean.getIntendedvector();
            List<Float> stableArray = JSON.parseArray(stableVectorStr,Float.class);
            Float[] stableVector = stableArray.toArray(new Float[stableArray.size()]);
            for(CategoryBean categoryBean:categoryBeans){
                float[] categoryVector = oldModel.getWordVector(categoryBean.getCategoryName());
                if(categoryVector==null) continue;
                categoryScoreTreeMap.put(W2VCalculator.similarity(categoryVector,stableVector),categoryBean.getCategoryName());
            }
            float[] newStableVector = new float[stableVector.length];
            int topK = 3;
            for(Map.Entry categoryScore:categoryScoreTreeMap.entrySet()){
                if(topK==0) break;
                float[] categoryVector = oldModel.getWordVector((String)categoryScore.getValue());
                if(categoryVector==null) continue;
                W2VCalculator.vectorPlus(newStableVector,categoryVector);
                W2VCalculator.toOne(newStableVector);
                topK--;
            }
            userVectorBean.setStablevector(Arrays.asList(newStableVector).toString());
            w2VModelService.uptadeOrInsertUserVector(userVectorBean);
        }
    }

    @Override
    public Object call() throws Exception {
        LOG.info("UserVectorRebuild开始");
        rebuild();
        LOG.info("UserVectorRebuild结束");
        return null;
    }
}
