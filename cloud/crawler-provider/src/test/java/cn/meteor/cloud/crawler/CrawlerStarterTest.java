package cn.meteor.cloud.crawler;

import cn.meteor.CrawlerProviderApplication;
import cn.meteor.cloud.crawler.starter.CrawlerStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.crawler
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 19:15
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 19:15
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrawlerProviderApplication.class)
public class CrawlerStarterTest {

    @Autowired
    CrawlerStarter crawlerStarter;

    @Test
    public void testStartCrawler(){
        crawlerStarter.startCrawler();
    }
}
