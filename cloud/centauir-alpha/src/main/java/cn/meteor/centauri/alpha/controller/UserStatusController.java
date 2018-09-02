package cn.meteor.centauri.alpha.controller;

import cn.meteor.centauri.alpha.bean.UserAction;
import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.oper.UserOper;
import cn.meteor.centauri.alpha.redis.service.RedisQueue;
import cn.meteor.centauri.alpha.returnmsg.BeanEmptyException;
import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.spacecraft.bean.NewsBean;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

/**
 * @ProjectName: data-provider
 * @Description: 用户行为状态controller
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 16:56
 * @Version: 1.0.0
 */
//@RestController(value = "/userstatus")
@RestController
public class UserStatusController {
    @Autowired
    UserOper userOper;
    @Autowired
    RedisQueue redisQueue;
    @Autowired
    KafkaTemplate kafkaTemplate;

    //新建用户
    @RequestMapping(value = "/init")
    public ReturnMsg init(@RequestParam(required=true)String userName,@RequestParam(required=true)String password){
        UserBean userBean = new UserBean();
        userBean.setUsername(userName);
        userBean.setPassword(password);
        return userOper.init(userBean);
    }

    //用户点赞
    @RequestMapping(value = "/like")
    public ReturnMsg like(@RequestParam(required=true)long userID,
                          @RequestParam(required=true)String newsCategory){
        UserBean userBean = new UserBean();
        userBean.setId(userID);
        NewsBean newsBean = new NewsBean();
        newsBean.setNewsCategory(newsCategory);
        JSONObject params = new JSONObject();
        params.put("type","like");
        params.put("userBean",userBean);
        params.put("newsBean",newsBean);
        redisQueue.pushMsg(params.toJSONString());
        kafkaTemplate.send("user_action",
                "like",
                 new UserAction(userID,
                         "like",
                         newsCategory,
                         Calendar.getInstance().getTimeInMillis()).toString());
//        return userOper.like(userBean,newsBean);
        return null;
    }

    //用户取消赞
    @RequestMapping(value = "/dislike")
    public ReturnMsg dislike(@RequestParam(required=true)long userID,
                             @RequestParam(required=true)String newsCategory) {
        UserBean userBean = new UserBean();
        userBean.setId(userID);
        NewsBean newsBean = new NewsBean();
        newsBean.setNewsCategory(newsCategory);
        ReturnMsg returnMsg = null;
        try {
            returnMsg = userOper.dislike(userBean,newsBean);
        } catch (BeanEmptyException e) {
            e.printStackTrace();
        }
        return returnMsg;
    }

    //用户请求新闻列表
    @RequestMapping(value = "/refresh")
    public List<NewsBean> refresh(@RequestParam(required=true)long userID) {
        UserBean userBean = new UserBean();
        userBean.setId(userID);
        List<NewsBean> userNewsBeanList = null ;
        try {
            userNewsBeanList = userOper.refresh(userBean);
        } catch (BeanEmptyException e) {
            e.printStackTrace();
        }
        return userNewsBeanList;
    }
}
