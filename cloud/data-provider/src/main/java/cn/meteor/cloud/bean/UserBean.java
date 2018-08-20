package cn.meteor.cloud.bean;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @ProjectName: data-provider
 * @Description: 用户类
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 15:59
 * @Version: 1.0.0
 */
public class UserBean implements Serializable {

    private long id;
    private String username;
    private String password;
    private String lastlogin;

    public UserBean(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}