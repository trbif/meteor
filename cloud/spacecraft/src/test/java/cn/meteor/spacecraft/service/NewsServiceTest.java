package cn.meteor.spacecraft.service;

import cn.meteor.SpacecraftProviderApplication;
import cn.meteor.spacecraft.bean.NewsBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.service
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 9:50
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/9 9:50
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpacecraftProviderApplication.class)
public class NewsServiceTest {

    @Autowired
    NewsService newsService;

    @Test
    public void testInsert(){
        NewsBean bean = new NewsBean();
        bean.setNewsContent("content");
        bean.setNewsLink("linklink");
        bean.setNewsTitle("titletitle");
        bean.setNewsPublishDate(Calendar.getInstance().getTimeInMillis());
        newsService.insert(bean);
    }

    @Test
    public void testFindByDatePeriod(){
        List<NewsBean> beans = newsService.getNewsList(Calendar.getInstance().getTimeInMillis()-1000*60*60*24*20,Calendar.getInstance().getTimeInMillis());
        int count=0;
        for(NewsBean bean:beans){
            if(count++>10) break;
            System.out.println(bean);
        }
    }

    @Test
    public void testFindByCategory(){
        System.out.println(newsService.getNewsListByCategory(Calendar.getInstance().getTimeInMillis()-24*60*60*1000,"IT"));
    }

}
