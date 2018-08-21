package cn.meteor.centauri.alpha.mapper;

import cn.meteor.spacecraft.bean.NewsBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ProjectName: crawler-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 16:07
 * @Version: 1.0.0
 */
@Mapper
public interface NewsMapper {
    @Select("SELECT * FROM NewsBean WHERE newsPublishDate BETWEEN #{newsPublishDateStart} AND #{newsPublishDateEnd}")
    public NewsBean findByDatePeriod(@Param("newsPublishDateStart") long start,
                                     @Param("newsPublishDateEnd") long end);
}
