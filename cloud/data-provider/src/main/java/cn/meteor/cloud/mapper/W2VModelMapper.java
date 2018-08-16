package cn.meteor.cloud.mapper;

import cn.meteor.cloud.bean.W2VModelBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.mapper
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:47
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 16:47
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Mapper
public interface W2VModelMapper {
    @Select("select * from W2VModelBean order by modelAccuracy DESC limit 0,1")
    public W2VModelBean getMostAccurateModel();
    @Insert("insert into w2vmodels(modelName,modelAccuracy,modelPublishDate,modelParams,modelVersion,modelSatisfaction) values(#{modelName}, #{modelAccuracy}, #{modelPublishDate}, #{modelParams}, #{modelVersion}, #{modelSatisfaction})")
    public void insert(W2VModelBean bean);
}
