package cn.meteor.cloud.crawler;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.service.NewsService;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.crawler
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 8:25
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 8:25
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface Crawler {
    public String classInfo();
    public List<NewsBean> seize(String url);
    public void setNewsService(NewsService newsService);
}
