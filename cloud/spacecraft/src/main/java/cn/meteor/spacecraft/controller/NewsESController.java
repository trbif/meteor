package cn.meteor.spacecraft.controller;

import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.repository.NewsRepository;
import org.apache.lucene.search.Query;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryShardContext;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.controller
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/14 14:57
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/14 14:57
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RestController
public class NewsESController {

    @Autowired
    private NewsRepository newsRepository;

    //http://localhost:8888/save
    @GetMapping("save")
    public String save(){
        NewsBean goodsInfo = new NewsBean();
        newsRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8888/delete?id=1525415333329
    @GetMapping("delete")
    public String delete(long id){
        newsRepository.deleteById(id);
        return "success";
    }

    //http://localhost:8888/update?id=1525417362754&name=修改&description=修改
    @GetMapping("update")
    public String update(long id,String name,String description){
        NewsBean goodsInfo = new NewsBean();
        newsRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8888/getOne?id=1525417362754
    @GetMapping("getOne")
    public Optional<NewsBean> getOne(long id){
        Optional<NewsBean> goodsInfo = newsRepository.findById(id);
        return goodsInfo;
    }


    //每页数量
    private Integer PAGESIZE=10;

    //http://localhost:8888/getGoodsList?query=商品
    //http://localhost:8888/getGoodsList?query=商品&pageNumber=1
    //根据关键字"商品"去查询列表，name或者description包含的都查询
    @GetMapping("getGoodsList")
    public List<NewsBean> getList(Integer pageNumber, String query){
        if(pageNumber==null) pageNumber = 0;
        //es搜索默认第一页页码是0
        SearchQuery searchQuery=getEntitySearchQuery(pageNumber,PAGESIZE,query);
        Page<NewsBean> goodsPage = newsRepository.search(searchQuery);
        return goodsPage.getContent();
    }


    private SearchQuery getEntitySearchQuery(int pageNumber, int pageSize, String searchContent) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(new QueryBuilder() {
            @Override
            public Query toQuery(QueryShardContext queryShardContext) throws IOException {
                return null;
            }

            @Override
            public Query toFilter(QueryShardContext queryShardContext) throws IOException {
                return null;
            }

            @Override
            public QueryBuilder queryName(String s) {
                return null;
            }

            @Override
            public String queryName() {
                return null;
            }

            @Override
            public float boost() {
                return 0;
            }

            @Override
            public QueryBuilder boost(float v) {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getWriteableName() {
                return null;
            }

            @Override
            public void writeTo(StreamOutput streamOutput) throws IOException {

            }

            @Override
            public XContentBuilder toXContent(XContentBuilder xContentBuilder, Params params) throws IOException {
                return null;
            }
        });
//                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                //设置权重分 求和模式
//                .scoreMode("sum")
//                //设置权重分最低分
//                .setMinScore(10);

        // 设置分页
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }

}