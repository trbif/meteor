package cn.meteor.spacecraft.crawler.impl;

import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.crawler.Crawler;
import cn.meteor.spacecraft.crawler.CrawlerAbstract;
import cn.meteor.spacecraft.service.NewsService;
import cn.meteor.spacecraft.utils.HttpRequest;
import cn.meteor.spacecraft.utils.MD5;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.crawler.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 8:21
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 8:21
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class SinaCrawler extends CrawlerAbstract implements Crawler{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private static String CHARSET = "utf-8";

    private NewsService newsService;
    private String category;

    @Override
    public String classInfo() {
        return this.getClass().toString();
    }

    public List<NewsBean> parseJsonP(String jsonP){

        List<NewsBean> list = new ArrayList<>();

        String tmp = jsonP.substring(jsonP.indexOf("\"data\":"));
        String jsonData = tmp.substring(tmp.indexOf("["),tmp.indexOf("]}")+1);

        JSONArray array = (JSONArray)JSONArray.parse(jsonData);
        for(int i=0;i<array.size();i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            NewsBean newsBean = new NewsBean();
            newsBean.setNewsCategory(category);
            LOG.info("excutor category:{}",category);
            newsBean.setNewsLink(jsonObject.getString("url"));
            newsBean.setNewsTags(jsonObject.getString("keywords"));
            newsBean.setNewsPublishDate(Long.valueOf(jsonObject.getString("ctime")+"000"));
            newsBean.setNewsTitle(jsonObject.getString("title"));
            newsBean.setNewsOriginalSummary(jsonObject.getString("summary"));
            HttpRequest requestInfo = new HttpRequest(newsBean.getNewsLink(), CHARSET);
            requestInfo.setMethod("GET");
            newsBean.setNewsContent(parseContent(requestInfo.request()));
            newsBean.setMd5(MD5.toMD5(newsBean.getNewsTitle()+newsBean.getNewsPublishDate()));
//            if(newsService.newsDuplicatedList(newsBean.getMd5()).size()==0)
            newsService.insert(newsBean);
            LOG.info("插入newsbean：{}",newsBean);
            list.add(newsBean);
        }

        return list;
    }


    public String parseContent(String html) {
        // TODO Auto-generated method stub
        Document document = Jsoup.parse(html);
        //content
        String content = document.getElementsByClass("content").text();

        return content;
    }

    @Override
    public List<NewsBean> seize(String url) {
        String result = "";
        List<NewsBean> newsBeanList = new ArrayList<NewsBean>();

        HttpRequest requestOSInfo = new HttpRequest(url, CHARSET);
        requestOSInfo.setMethod("GET");
        result = requestOSInfo.request();
        newsBeanList.addAll(parseJsonP(result));
        return parseJsonP(result);
    }

    @Override
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
