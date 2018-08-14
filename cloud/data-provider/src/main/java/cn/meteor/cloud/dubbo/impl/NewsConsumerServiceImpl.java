package cn.meteor.cloud.dubbo.impl;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.dubbo.NewsConsumerService;
import cn.meteor.cloud.dubbo.NewsDubboService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: meteor
 * @Package: cn.meteor.cloud.service.dubbo.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/13 15:01
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/13 15:01
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
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
}
