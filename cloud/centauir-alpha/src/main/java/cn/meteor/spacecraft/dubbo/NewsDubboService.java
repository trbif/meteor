package cn.meteor.spacecraft.dubbo;

import cn.meteor.spacecraft.bean.NewsBean;

import java.util.List;

/**
 * @ProjectName: meteor
 * @Description: dubbo消费接口 同cralwer中的接口
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/13 10:58
 * @Version: 1.0.0
 */
public interface NewsDubboService {
    public List<NewsBean> getNewsList(long start, long end);
}
