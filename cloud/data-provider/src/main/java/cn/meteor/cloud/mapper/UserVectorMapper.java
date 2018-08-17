package cn.meteor.cloud.mapper;

import cn.meteor.cloud.bean.UserVectorBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.mapper
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 11:16
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/17 11:16
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface UserVectorMapper {
    @Insert("insert into uservector " +
            "(userid,stablevector,currentvector,intendedvector,version)  " +
            "values(#{userid},#{stablevector},#{currentvector},#{intendedvector},#{version}) " +
            "on  DUPLICATE key update stablevector=#{stablevector},currentvector=#{currentvector},intendedvector=#{intendedvector},version=#{version}")
    public void uptadeOrInsert(UserVectorBean bean);

    @Select("select stablevector,currentvector,intendedvector,version from uservector where userid=#{userid}")
    public UserVectorBean getByUserid(@Param("userid") long userid);
}
