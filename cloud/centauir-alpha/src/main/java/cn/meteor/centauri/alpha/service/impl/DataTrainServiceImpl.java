package cn.meteor.centauri.alpha.service.impl;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.mapper.NewsMapper;
import cn.meteor.centauri.alpha.mapper.UserMapper;
import cn.meteor.centauri.alpha.service.DataTrainService;
import cn.meteor.spacecraft.bean.NewsBean;

import javax.annotation.Resource;
import java.util.List;
/**
 * @ProjectName: crawler-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 9:47
 * @Version: 1.0.0
 */
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
