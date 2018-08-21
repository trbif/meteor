package cn.meteor.centauri.alpha.mapper;

import cn.meteor.centauri.alpha.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 16:07
 * @Version: 1.0.0
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    public UserBean find(@Param("username") String username);

    @Select("select id from user where lastlogin > #{lastlogin}")
    public List<UserBean> getListByLoginTime(@Param("lastlogin") long lastlogin);

    @Insert("insert into user(username,password,lastlogin) values (#{userBean.username},#{userBean.password},#{userBean.lastlogin})")
    @Options(useGeneratedKeys = true, keyProperty = "userBean.id")
    public void insert(@Param("userBean") UserBean userBean);
}
