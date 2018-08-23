package cn.meteor.hubble.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @ProjectName: hubble
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/23 8:54
 * @Version: 1.0.0
 */
public class ServerConfig implements Serializable {

    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}
