package cn.meteor.cloud.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @ProjectName: data-provider
 * @Description: 用户向量类
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 15:59
 * @Version: 1.0.0
 */
public class UserVectorBean implements Serializable {

    private long id;
    private long  userid;
    private String stablevector;
    private String currentvector;
    private String intendedvector;
    private String version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStablevector() {
        return stablevector;
    }

    public void setStablevector(String stablevector) {
        this.stablevector = stablevector;
    }

    public String getCurrentvector() {
        return currentvector;
    }

    public void setCurrentvector(String currentvector) {
        this.currentvector = currentvector;
    }

    public String getIntendedvector() {
        return intendedvector;
    }

    public void setIntendedvector(String intendedvector) {
        this.intendedvector = intendedvector;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}