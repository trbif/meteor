package cn.meteor.centauri.alpha.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @ProjectName: alpha-centauri
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/9/2
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class UserAction implements Serializable {

    private String actionName;
    private long userID;
    private long actionTime;
    private String actions;

    public UserAction(long userID,String actionName,String actions,long actionTime){
        this.userID = userID;
        this.actionName = actionName;
        this.actions = actions;
        this.actionTime = actionTime;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getActionTime() {
        return actionTime;
    }

    public void setActionTime(long actionTime) {
        this.actionTime = actionTime;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}
