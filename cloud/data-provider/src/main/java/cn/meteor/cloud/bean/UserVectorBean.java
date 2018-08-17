package cn.meteor.cloud.bean;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.bean
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 15:59
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 15:59
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * User实体类
 * @author Administrator
 *
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