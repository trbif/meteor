package cn.meteor.spacecraft.mapper;

import cn.meteor.spacecraft.bean.CategoryBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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
    public List<CategoryBean> findAll();
    public void insert(CategoryBean categoryBean);
}
