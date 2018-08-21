package cn.meteor.centauri.alpha.service;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.spacecraft.bean.NewsBean;

import java.util.List;
/**
 * @ProjectName: crawler-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 9:47
 * @Version: 1.0.0
 */
public interface DataTrainService {
    public List<NewsBean> getRefreshNewsList(UserBean user);
}
