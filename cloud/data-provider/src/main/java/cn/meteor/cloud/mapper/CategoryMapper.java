package cn.meteor.cloud.mapper;

import cn.meteor.cloud.bean.CategoryBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface CategoryMapper {
    @Select("SELECT * FROM category")
    public List<CategoryBean> findAll();
}
