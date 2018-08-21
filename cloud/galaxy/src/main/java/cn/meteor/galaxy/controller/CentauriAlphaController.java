package cn.meteor.galaxy.controller;

import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.galaxy.service.CentauriAlphaService;
import cn.meteor.spacecraft.bean.NewsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CentauriAlphaController {
    @Autowired
    CentauriAlphaService centauriAlphaService;

    //新建用户
    @RequestMapping(value = "/init")
    public ReturnMsg init(@RequestParam(required=true)String userName,@RequestParam(required=true)String password){
        return centauriAlphaService.init(userName,password);
    }

    //用户点赞
    @RequestMapping(value = "/like")
    public ReturnMsg like(@RequestParam(required=true)long userID,
                          @RequestParam(required=true)String newsCategory){
        return centauriAlphaService.like(userID,newsCategory);
    }

    //用户取消赞
    @RequestMapping(value = "/dislike")
    public ReturnMsg dislike(@RequestParam(required=true)long userID,
                             @RequestParam(required=true)String newsCategory){
        return centauriAlphaService.dislike(userID,newsCategory);
    }

    //用户请求新闻列表
    @RequestMapping(value = "/refresh")
    public List<NewsBean> refresh(@RequestParam(required=true)long userID){
        return centauriAlphaService.refresh(userID);
    }
}
