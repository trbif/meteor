package cn.meteor.cloud.mapper.impl;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.mapper.NewsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.mapper.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 10:38
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 10:38
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Repository
public class NewsMapperImpl implements NewsMapper {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public List<NewsBean> findByDatePeriod(long newsPublishDateStart, long newsPublishDateEnd) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            NewsMapper mapper = session.getMapper(NewsMapper.class);
            return  mapper.findByDatePeriod(newsPublishDateStart, newsPublishDateEnd);
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(NewsBean bean) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            NewsMapper mapper = session.getMapper(NewsMapper.class);
            mapper.insert(bean);
        } finally {
            session.close();
        }
    }

    @Override
    public List<NewsBean> findByMD5(String md5) {
        return null;
    }
}
