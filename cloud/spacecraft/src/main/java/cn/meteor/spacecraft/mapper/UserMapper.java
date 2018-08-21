package cn.meteor.spacecraft.mapper;

import cn.meteor.spacecraft.bean.User;
import org.apache.ibatis.annotations.Param;

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
public interface UserMapper {
    public User find(@Param("username") String username);
}
