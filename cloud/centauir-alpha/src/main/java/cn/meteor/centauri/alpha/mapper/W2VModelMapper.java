package cn.meteor.centauri.alpha.mapper;

import cn.meteor.centauri.alpha.bean.W2VModelBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:47
 * @Version: 1.0.0
 */
@Mapper
public interface W2VModelMapper {
    @Select("select * from w2vmodels order by modelAccuracy DESC limit 0,1")
    public W2VModelBean getMostAccurateModel();

    @Insert("insert into w2vmodels(modelName,modelAccuracy,modelPublishDate,modelParams,modelVersion,modelSatisfaction) values(#{modelName}, #{modelAccuracy}, #{modelPublishDate}, #{modelParams}, #{modelVersion}, #{modelSatisfaction})")
    public void insert(W2VModelBean bean);
}
