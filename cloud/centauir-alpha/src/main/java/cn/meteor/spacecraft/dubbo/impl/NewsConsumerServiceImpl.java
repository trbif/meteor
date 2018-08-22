package cn.meteor.spacecraft.dubbo.impl;

import cn.meteor.spacecraft.bean.CategoryBean;
import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.dubbo.NewsConsumerService;
import cn.meteor.spacecraft.dubbo.NewsDubboService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: meteor
 * @Description: dubbo消费类 RPC调用crawler中的相应service
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/13 15:01
 * @Version: 1.0.0
 */
@Component
public class NewsConsumerServiceImpl implements NewsConsumerService {

    @Reference(version = "1.0.0",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    NewsDubboService newsDubboService;

    @Override
    public List<NewsBean> getNewsList(long start, long end) {
        return newsDubboService.getNewsList(start,end);
    }

    @Override
    public List<CategoryBean> getAllCategories() {
        return newsDubboService.getAllCategories();
    }
}
