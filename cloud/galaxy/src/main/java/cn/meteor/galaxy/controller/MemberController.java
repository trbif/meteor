package cn.meteor.galaxy.controller;

import cn.meteor.galaxy.service.MemberService;
import cn.meteor.spacecraft.bean.NewsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;
    @RequestMapping("/getOrderUserAll")
    public List<String> getOrderUserList(){
        return memberService.getOrderByUserList();
    }

    @RequestMapping("/getNewsList")
    public List<NewsBean> getNewsList(@RequestParam(required=true)long start,
                                      @RequestParam(required=true)long end){
        return memberService.getNewsList(start,end);
    }

    @RequestMapping("/getNews")
    public List<NewsBean> getNews(){
        return memberService.getNews();
    }

}
