package cn.meteor.cloud.service.impl;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.mapper.UserMapper;
import cn.meteor.cloud.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.data.service.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 8:48
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 8:48
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserBean getUserList(String userName) {
        return userMapper.find(userName);
    }

    @Override
    public List<NewsBean> getUserStableList(UserBean userBean) {
        return null;
    }

    @Override
    public List<NewsBean> getUserCurrentList(UserBean userBean) {
        return null;
    }

    @Override
    public List<NewsBean> getUserIntendedList(UserBean userBean) {
        return null;
    }
}
