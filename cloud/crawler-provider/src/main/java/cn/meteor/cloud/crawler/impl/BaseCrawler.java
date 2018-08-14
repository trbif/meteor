package cn.meteor.cloud.crawler.impl;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.crawler.Crawler;
import cn.meteor.cloud.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.crawler.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 8:21
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 8:21
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class BaseCrawler implements Crawler{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public String classInfo() {
        return this.getClass().toString();
    }

    @Override
    public List<NewsBean> seize(String url) {
        LOG.info("爬虫开始");
        return null;
    }

    @Override
    public void setNewsService(NewsService newsService) {

    }

}
