package cn.meteor.spacecraft.mapper.impl;

import cn.meteor.spacecraft.bean.CategoryBean;
import cn.meteor.spacecraft.mapper.CategoryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: spacecraft
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/22 14:55
 * @Version: 1.0.0
 */
@Repository
public class CategoryMapperImpl implements CategoryMapper {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public List<CategoryBean> findAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return  mapper.findAll();
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(CategoryBean categoryBean) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.insert(categoryBean);
            LOG.debug("newsbean insert:{}",categoryBean);
            session.commit();
        } finally {
            session.close();
        }
    }
}
