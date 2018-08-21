package cn.meteor.centauri.alpha.controller;

import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.spacecraft.bean.NewsBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName: alpha-centauri
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/21 10:22
 * @Version: 1.0.0
 */
public interface UserStatus {
    @RequestMapping(value = "/init")
    public ReturnMsg init(@RequestParam(required=true)String userName);
    @RequestMapping(value = "/like")
    public ReturnMsg like(@RequestParam(required = true) long userID, @RequestParam(required = true) String newsCategory);
    @RequestMapping(value = "/dislike")
    public ReturnMsg dislike(@RequestParam(required = true) long userID, @RequestParam(required = true) String newsCategory);
    @RequestMapping(value = "/refresh")
    public List<NewsBean> refresh(@RequestParam(required = true) long userID);
}
