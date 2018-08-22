package cn.meteor.spacecraft.crawler;

import cn.meteor.SpacecraftProviderApplication;
import cn.meteor.spacecraft.crawler.impl.ZOLCrawler;
import cn.meteor.spacecraft.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: spacecraft
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/22 9:33
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpacecraftProviderApplication.class)
public class ZOLCrawlerTest {
    @Autowired
    NewsService newsService;
    @Test
    public void testZOLCrawler(){
        Crawler crawler = new ZOLCrawler();
        crawler.setCategory("手机");
        crawler.setNewsService(newsService);
        System.out.println(crawler.seize("http://mobile.zol.com.cn/list.html"));
    }
}
