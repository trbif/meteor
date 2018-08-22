package cn.meteor.spacecraft.crawler.impl;

import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.crawler.Crawler;
import cn.meteor.spacecraft.crawler.CrawlerAbstract;
import cn.meteor.spacecraft.service.NewsService;
import cn.meteor.spacecraft.utils.HttpRequest;
import cn.meteor.spacecraft.utils.MD5;
import cn.meteor.spacecraft.utils.TimeUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: spacecraft
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/22 9:15
 * @Version: 1.0.0
 */
public class ZOLCrawler extends CrawlerAbstract implements Crawler {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private final static String CHARSET = "gbk";
    private final static String SOURCE = "zol";
    private NewsService newsService;
    private String category;

    @Override
    public String classInfo() {
        return this.getClass().toString();
    }

    public List<NewsBean> parse(String html) {
        List<NewsBean> list = new ArrayList<>();

        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("mobile-list-r");

        if (null != elements && 1 <= elements.size()) {
            for(Element ul: elements){
                Elements li = ul.getElementsByTag("li");
                for(Element lii: li){
                    String href = lii.getElementsByTag("a").attr("href");
                    String title = lii.getElementsByTag("a").attr("title");
                    NewsBean bean = new NewsBean();
                    bean.setNewsLink(href);
                    bean.setNewsTitle(title);
                    list.add(bean);
                }
            }
        }
        return list;
    }

    public void fillBean(String html, NewsBean newsBean) {
        String result = "";
        Document document = Jsoup.parse(html);

        Element pubtime = document.getElementById("pubtime_baidu");
        if(pubtime == null){
            return;
        }
        String publishTime = document.getElementById("pubtime_baidu").attr("content");
        Element element = document.getElementById("article-content");
        try {
            if(element == null)
                return;
            result = element.text();
            newsBean.setNewsCategory(category);
            LOG.debug("excutor category:{}",category);
            newsBean.setNewsTags(" ");
            newsBean.setNewsPublishDate(TimeUtil.dateToStamp(publishTime));
            newsBean.setNewsOriginalSummary(" ");
            newsBean.setNewsSource(SOURCE);
            newsBean.setNewsContent(result);
            newsBean.setMd5(MD5.toMD5(newsBean.getNewsTitle()+newsBean.getNewsPublishDate()));
            newsService.insert(newsBean);
            LOG.debug("插入newsbean：{}",newsBean);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<NewsBean> parseList(String html){

        List<NewsBean> list = new ArrayList<>();

        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByClass("content-list imglazyload").get(0).children();
        if (null != elements && 1 <= elements.size()) {
            for(Element li: elements){
                Element titleE = null;
                if(li.getElementsByClass("info-head").size()>0){
                    titleE = li.getElementsByClass("info-head").get(0);
                }
                if(titleE==null) continue;
                String href = titleE.getElementsByTag("a").attr("href");
                String title = titleE.getElementsByTag("a").text();
                NewsBean bean = new NewsBean();
                bean.setNewsLink(href);
                bean.setNewsTitle(title);
                list.add(bean);
            }
        }
        return list;
    }

    @Override
    public List<NewsBean> seize(String url) {
        HttpRequest requestZOLListInfo = new HttpRequest(url, CHARSET);
        requestZOLListInfo.setMethod("GET");
        String resultZOL = requestZOLListInfo.request();

        List<NewsBean> zolListList = parseList(resultZOL);
        LOG.debug("zolListList:{}",zolListList.size());

        int limit = 0;
        for (NewsBean newsBean : zolListList) {
            HttpRequest requestBeanInfo = new HttpRequest(newsBean.getNewsLink(), CHARSET);
            requestBeanInfo.setMethod("GET");
            String resultBean = requestBeanInfo.request();
            fillBean(resultBean,newsBean);
            LOG.debug("newsBean:{}-{}",limit,newsBean);
            limit++;
        }
        return zolListList;
    }

    @Override
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }
}
