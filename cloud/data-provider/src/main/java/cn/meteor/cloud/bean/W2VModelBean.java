package cn.meteor.cloud.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.bean
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:48
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 16:48
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
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

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}
