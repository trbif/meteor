package cn.meteor.spacecraft.service;

import cn.meteor.spacecraft.bean.NewsBean;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.service
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 9:45
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/9 9:45
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface NewsService {
    public void insert(NewsBean bean);
    public List<NewsBean> getNewsList(long start,long end);
    public List<NewsBean> getNewsListByCategory(long limitedTime,String categoryName);
}
