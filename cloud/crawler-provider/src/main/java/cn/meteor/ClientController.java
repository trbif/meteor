package cn.meteor;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.User;
import cn.meteor.cloud.crawler.impl.SinaCrawler;
import cn.meteor.cloud.crawler.starter.CrawlerStarter;
import cn.meteor.cloud.service.CrawlerService;
import cn.meteor.cloud.service.NewsService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
//@ComponentScan({"cn.meteor.cloud.service"})
//@MapperScan({"cn.meteor.cloud.mapper"})
public class ClientController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${server.port}")
    private String serverport;

    int count = 0;

    @RequestMapping("/getUserList")
    public List<String> getUserList() {
        List<String> listUser = new ArrayList<String>();
        listUser.add("zhangsan");
        listUser.add("lisi");
        listUser.add("yushengjun");
        listUser.add(serverport);
        return listUser;
    }
    @Autowired
    CrawlerStarter crawlerStarter;
    @Autowired
    CrawlerService crawlerService;

    @RequestMapping("/startCrawler")
    public String startCrawler() {
        crawlerStarter.startCrawler();
        return "start";
    }
    @RequestMapping("/reload")
    public String reload() {
        crawlerStarter.reload();
        return "reload";
    }
    @RequestMapping("/user")
    public User user() {
        crawlerStarter.reload();
        return crawlerService.find("小明");
    }
//    非线程安全
    @RequestMapping("/counttest")
    public int counttest() {
        synchronized(this){
            count++;
        }
        return count;
    }
    @RequestMapping("/count")
    public int count() {
        return count;
    }

    @Autowired
    NewsService newsService;

    @RequestMapping("/testInsert")
    public String testInsert(){
        NewsBean bean = new NewsBean();
        bean.setNewsContent("content");
        bean.setNewsLink("linklink");
        bean.setNewsTitle("titletitle");
        bean.setNewsPublishDate(Calendar.getInstance().getTimeInMillis());
        bean.setMd5("md5");
        newsService.insert(bean);
        return "success";
    }

    @RequestMapping("/testSina")
    public List<NewsBean> testSina(){
        SinaCrawler crawler = new SinaCrawler();
        return crawler.seize("");
    }
}
