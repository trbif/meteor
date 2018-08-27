package cn.meteor.centauri.alpha.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ProjectName: data-provider
 * @Description: word2vec模型类
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:48
 * @Version: 1.0.0
 */
public class W2VModelBean {
    //'模型id'
    private long id;
    //'模型名称'
    private String modelName;
    //'模型精度'
    private double modelAccuracy;
    //'模型创建日期'
    private long modelPublishDate;
    //'模型参数'
    private String modelParams;
    //'模型版本'
    private String modelVersion;
    //'模型满意度'
    private double modelSatisfaction;
    //'模型最近使用时间'
    private long modelRecentUsedTime;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getModelAccuracy() {
        return modelAccuracy;
    }

    public void setModelAccuracy(double modelAccuracy) {
        this.modelAccuracy = modelAccuracy;
    }

    public long getModelPublishDate() {
        return modelPublishDate;
    }

    public void setModelPublishDate(long modelPublishDate) {
        this.modelPublishDate = modelPublishDate;
    }

    public String getModelParams() {
        return modelParams;
    }

    public void setModelParams(String modelParams) {
        this.modelParams = modelParams;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public double getModelSatisfaction() {
        return modelSatisfaction;
    }

    public void setModelSatisfaction(double modelSatisfaction) {
        this.modelSatisfaction = modelSatisfaction;
    }

    public long getModelRecentUsedTime() {
        return modelRecentUsedTime;
    }

    public void setModelRecentUsedTime(long modelRecentUsedTime) {
        this.modelRecentUsedTime = modelRecentUsedTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}
