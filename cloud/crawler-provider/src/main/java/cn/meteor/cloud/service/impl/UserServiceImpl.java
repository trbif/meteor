package cn.meteor.cloud.service.impl;

import cn.meteor.cloud.bean.User;
import cn.meteor.cloud.mapper.UserMapper;
import cn.meteor.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.service.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 9:47
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 9:47
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User find(String username) {
        return userMapper.find(username);
    }
}
