package cn.meteor.cloud.mapper;

import cn.meteor.cloud.bean.NewsBean;
import org.apache.ibatis.annotations.*;

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
//@Mapper
public interface NewsMapper {

//    @Select("SELECT newsTags,newsOriginalSummary,newsTitle FROM News WHERE newsPublishDate BETWEEN #{newsPublishDateStart} AND #{newsPublishDateEnd}")
    public List<NewsBean> findByDatePeriod(@Param("newsPublishDateStart") long newsPublishDateStart,
                                         @Param("newsPublishDateEnd") long newsPublishDateEnd);

    //SelectProvider实现方式，当语句不简洁时，使用比较合适 08-10 15:14
/*    @SelectProvider(type = FindByDatePeriodSqlBuilder.class, method = "buildFindByDatePeriodSql")
    class FindByDatePeriodSqlBuilder {
        public static String buildFindByDatePeriodSql(Map<String, Object> para) {
            return new SQL(){{
                SELECT("*");
                FROM("news");
                if ((long)para.get("newsPublishDateStart")<=(long)para.get("newsPublishDateEnd")) {
                    WHERE("newsPublishDate BETWEEN "+para.get("newsPublishDateStart")+" AND "+para.get("newsPublishDateEnd"));
                }
                ORDER_BY("id");
            }}.toString();
        }
    }*/

//    @Insert({ "insert ignore into news(md5,newsTitle,newsPublishDate,newsTags,newsLink,newsContent,contentFeature,newsOriginalSummary,newsSummary,newsKeyword,newsPicUrl,newsVideoUrl) values(#{md5}, #{newsTitle}, #{newsPublishDate}, #{newsTags}, #{newsLink}, #{newsContent}, #{contentFeature}, #{newsOriginalSummary}, #{newsSummary}, #{newsKeyword}, #{newsPicUrl}, #{newsVideoUrl})"})
    public void insert(NewsBean bean);

//    @Select("SELECT * FROM News WHERE md5 = #{md5}")
    public List<NewsBean> findByMD5(@Param("md5") String md5);
}
