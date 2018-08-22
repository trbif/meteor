package cn.meteor.spacecraft.service;

import cn.meteor.spacecraft.bean.CategoryBean;

import java.util.List;

/**
 * @ProjectName: spacecraft
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/22 14:58
 * @Version: 1.0.0
 */
public interface CategoryService {
    public List<CategoryBean> getAllCategories();
    public long insert(CategoryBean categoryBean);
}
