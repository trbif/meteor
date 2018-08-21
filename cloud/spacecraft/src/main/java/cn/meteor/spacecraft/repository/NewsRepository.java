package cn.meteor.spacecraft.repository;

import cn.meteor.spacecraft.bean.NewsBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.repository
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/14 14:44
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/14 14:44
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Component
public interface NewsRepository extends ElasticsearchRepository<NewsBean,Long>  {
}
