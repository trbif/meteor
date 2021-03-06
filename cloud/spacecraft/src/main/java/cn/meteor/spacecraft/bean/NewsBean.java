package cn.meteor.spacecraft.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.bean
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 9:12
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/9 9:12
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Document(indexName = "news",type = "goods")
public class NewsBean implements Serializable {

    //新闻id
    private long id;
    //新闻md5
    private String md5;
    //新闻标题
    private String newsTitle;
    //新闻发布日期
    private long newsPublishDate;
    //新闻标签
    private String newsTags;
    //新闻链接
    private String newsLink;
    //新闻正文
    private String newsContent;
    //新闻特征值
    private String contentFeature;
    //新闻原本摘要
    private String newsOriginalSummary;
    //新闻提取出的摘要
    private String newsSummary;
    //新闻提取出的关键词
    private String newsKeyword;
    //新闻图片链接
    private String newsPicUrl;
    //新闻视频链接
    private String newsVideoUrl;
    //新闻类型
    private String newsCategory;
    //新闻来源
    private String newsSource;

    public long getNewsID() {
        return id;
    }

    public void setNewsID(long id) {
        this.id = id;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public long getNewsPublishDate() {
        return newsPublishDate;
    }

    public void setNewsPublishDate(long newsPublishDate) {
        this.newsPublishDate = newsPublishDate;
    }

    public String getNewsTags() {
        return newsTags;
    }

    public void setNewsTags(String newsTags) {
        this.newsTags = newsTags;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getContentFeature() {
        return contentFeature;
    }

    public void setContentFeature(String contentFeature) {
        this.contentFeature = contentFeature;
    }

    public String getNewsOriginalSummary() {
        return newsOriginalSummary;
    }

    public void setNewsOriginalSummary(String newsOriginalSummary) {
        this.newsOriginalSummary = newsOriginalSummary;
    }

    public String getNewsSummary() {
        return newsSummary;
    }

    public void setNewsSummary(String newsSummary) {
        this.newsSummary = newsSummary;
    }

    public String getNewsKeyword() {
        return newsKeyword;
    }

    public void setNewsKeyword(String newsKeyword) {
        this.newsKeyword = newsKeyword;
    }

    public String getNewsPicUrl() {
        return newsPicUrl;
    }

    public void setNewsPicUrl(String newsPicUrl) {
        this.newsPicUrl = newsPicUrl;
    }

    public String getNewsVideoUrl() {
        return newsVideoUrl;
    }

    public void setNewsVideoUrl(String newsVideoUrl) {
        this.newsVideoUrl = newsVideoUrl;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}
