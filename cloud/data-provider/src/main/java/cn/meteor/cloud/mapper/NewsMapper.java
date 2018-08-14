package cn.meteor.cloud.mapper;

import cn.meteor.cloud.bean.NewsBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
public interface NewsMapper {

    @Select("SELECT * FROM NewsBean WHERE newsPublishDate BETWEEN #{newsPublishDateStart} AND #{newsPublishDateEnd}")
    public NewsBean findByDatePeriod(@Param("newsPublishDateStart") long start,
                                     @Param("newsPublishDateEnd") long end);
}
