package cn.meteor.spacecraft.dubbo.impl;

import cn.meteor.spacecraft.bean.CategoryBean;
import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.dubbo.NewsDubboService;
import cn.meteor.spacecraft.service.CategoryService;
import cn.meteor.spacecraft.service.NewsService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ProjectName: meteor
 * @Package: cn.meteor.cloud.service.dubbo.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/13 10:58
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/13 10:58
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class NewsDubboServiceImpl implements NewsDubboService {

    @Autowired
    NewsService newsService;
    @Autowired
    CategoryService categoryService;

    @Override
    public List<NewsBean> getNewsList(long start,long end) {
        return newsService.getNewsList(start,end);
    }

    @Override
    public List<CategoryBean> getAllCategories() {
        return categoryService.getAllCategories();
    }

}
