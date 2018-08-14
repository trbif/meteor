package cn.meteor.cloud.controller;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.controller
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 15:16
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 15:16
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RestController
public class ServiceController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    NewsService newsService;

    @RequestMapping("/getNewsList")
    public List<NewsBean> getNewsList(@RequestParam(required=true)long start,
                                      @RequestParam(required=true)long end){
        return newsService.getNewsList(start,end);
    }

    @RequestMapping("/getNews")
    public List<NewsBean> getNewsList(){
        return newsService.getNewsList(1531885866000L,1533885866000L);
    }
}
