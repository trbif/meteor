package cn.meteor.cloud.controller;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.dubbo.NewsConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Description: dubbo验证
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 15:16
 * @Version: 1.0.0
 */
@RestController
public class ServiceController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    NewsConsumerService newsConsumerService;

    @RequestMapping("/getDubbo")
    public List<NewsBean> getDubbo() {
        return newsConsumerService.getNewsList(1L,1L);
    }


    @RequestMapping("/getNewsList")
    public List<NewsBean> getNewsList(@RequestParam(required=true)long start,
                                      @RequestParam(required=true)long end){
        return newsConsumerService.getNewsList(start,end);
    }
}
