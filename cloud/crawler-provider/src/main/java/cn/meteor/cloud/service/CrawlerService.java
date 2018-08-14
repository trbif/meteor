package cn.meteor.cloud.service;


import cn.meteor.cloud.bean.User;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.service.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 9:48
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 9:48
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface CrawlerService {
    public User find(String username);
}
