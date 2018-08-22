package cn.meteor.spacecraft.crawler.impl;

import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.crawler.Crawler;
import cn.meteor.spacecraft.crawler.CrawlerAbstract;
import cn.meteor.spacecraft.service.NewsService;

import java.util.List;

/**
 * @ProjectName: spacecraft
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/22 10:41
 * @Version: 1.0.0
 */
public class KejixunCrawler extends CrawlerAbstract implements Crawler {

    private NewsService newsService;
    private String category;

    @Override
    public String classInfo() {
        return this.getClass().toString();
    }

    @Override
    public List<NewsBean> seize(String url) {
        return null;
    }

    @Override
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }
}
