package cn.meteor.consumer.controller;

import cn.meteor.consumer.bean.NewsBean;
import cn.meteor.consumer.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {
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
