package cn.meteor.spacecraft.service.impl;

import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.mapper.NewsMapper;
import cn.meteor.spacecraft.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.service.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 9:47
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/9 9:47
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public void insert(NewsBean bean) {
        newsMapper.insert(bean);
    }

    @Override
    public List<NewsBean> getNewsList(long start,long end) {
        return newsMapper.findByDatePeriod(start,end);
    }

}
