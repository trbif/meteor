package cn.meteor.spacecraft.service.impl;

import cn.meteor.spacecraft.bean.CategoryBean;
import cn.meteor.spacecraft.mapper.CategoryMapper;
import cn.meteor.spacecraft.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: spacecraft
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/22 14:59
 * @Version: 1.0.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryBean> getAllCategories() {
        return categoryMapper.findAll();
    }

    @Override
    public long insert(CategoryBean categoryBean) {
        categoryMapper.insert(categoryBean);
        return categoryBean.getId();
    }
}
