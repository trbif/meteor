package cn.meteor.cloud.mapper;

import cn.meteor.cloud.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.mapper
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 16:07
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 16:07
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    public UserBean find(@Param("username") String username);

    @Select("select id from user where lastlogin > #{lastlogin}")
    public List<UserBean> getListByLoginTime(@Param("lastlogin") long lastlogin);

    @Insert("insert into user(username,password,lastlogin) values (#{username},#{password},#{lastlogin})")
    public void insert(UserBean userBean);
}
