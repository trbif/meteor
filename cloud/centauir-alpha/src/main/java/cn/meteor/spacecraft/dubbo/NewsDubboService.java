package cn.meteor.spacecraft.dubbo;

import cn.meteor.spacecraft.bean.CategoryBean;
import cn.meteor.spacecraft.bean.NewsBean;

import java.util.List;

/**
 * @ProjectName: meteor
 * @Package: cn.meteor.cloud.service.dubbo
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
public interface NewsDubboService {
    public List<NewsBean> getNewsList(long start, long end);
    public List<CategoryBean> getAllCategories();
}
