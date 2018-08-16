package cn.meteor.cloud.service;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.UserBean;

import java.util.List;

public interface DataTrainService {
    public List<NewsBean> getRefreshNewsList(UserBean user);
}
