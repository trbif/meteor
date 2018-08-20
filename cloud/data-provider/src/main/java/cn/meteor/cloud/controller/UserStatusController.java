package cn.meteor.cloud.controller;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.oper.UserOper;
import cn.meteor.cloud.returnmsg.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Description: 用户行为状态controller
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 16:56
 * @Version: 1.0.0
 */
@RestController("/userstatus")
public class UserStatusController {
    @Autowired
    UserOper userOper;

    //新建用户
    @RequestMapping(value = "/init")
    public ReturnMsg init(@RequestParam(required=true)String userName){
        UserBean userBean = new UserBean();
        userBean.setUsername(userName);
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
        return userOper.like(userBean,newsBean);
    }

    //用户取消赞
    @RequestMapping(value = "/dislike")
    public ReturnMsg dislike(@RequestParam(required=true)long userID,
                          @RequestParam(required=true)String newsCategory){
        UserBean userBean = new UserBean();
        userBean.setId(userID);
        NewsBean newsBean = new NewsBean();
        newsBean.setNewsCategory(newsCategory);
        return userOper.dislike(userBean,newsBean);
    }

    //用户请求新闻列表
    @RequestMapping(value = "/refresh")
    public List<NewsBean> refresh(@RequestParam(required=true)long userID){
        return null;
    }
}
