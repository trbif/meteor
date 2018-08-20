package cn.meteor.cloud.mapper;

import cn.meteor.cloud.bean.CategoryBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 16:07
 * @Version: 1.0.0
 */
@Mapper
public interface CategoryMapper {
    @Select("SELECT * FROM category")
    public List<CategoryBean> findAll();
}
