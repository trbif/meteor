package cn.meteor.cloud.service.impl;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.mapper.NewsMapper;
import cn.meteor.cloud.mapper.UserMapper;
import cn.meteor.cloud.service.DataTrainService;

import javax.annotation.Resource;
import java.util.List;

public class DataTrainServiceImpl implements DataTrainService {

    @Resource
    NewsMapper newsMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public List<NewsBean> getRefreshNewsList(UserBean user) {
        return null;
    }
}
