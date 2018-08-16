package cn.meteor.cloud.mapper.impl;

import cn.meteor.cloud.bean.User;
import cn.meteor.cloud.mapper.NewsMapper;
import cn.meteor.cloud.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.mapper.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 11:10
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 11:10
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Repository
public class UserMapperImpl implements UserMapper {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public User find(String username) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.find(username);
        } finally {
            session.close();
        }
    }
}
