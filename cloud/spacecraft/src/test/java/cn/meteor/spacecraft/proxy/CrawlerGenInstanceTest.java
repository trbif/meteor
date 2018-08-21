package cn.meteor.spacecraft.proxy;

import cn.meteor.SpacecraftProviderApplication;
import cn.meteor.spacecraft.crawler.Crawler;
import cn.meteor.spacecraft.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.proxy
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 8:36
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 8:36
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpacecraftProviderApplication.class)
public class CrawlerGenInstanceTest {

    @Autowired
    NewsService newsService;

    @Test
    public void testCrawlerGenInstanceTest() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        CrawlerGenInstance instance = CrawlerGenInstance.getInstance();
        String className = "cn.meteor.cloud.crawler.impl.BaseCrawler";
        Crawler crawler = instance.get(className,newsService);
        System.out.println(crawler.classInfo());
    }
}
