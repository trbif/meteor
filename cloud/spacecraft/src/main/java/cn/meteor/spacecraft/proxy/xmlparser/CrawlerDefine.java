package cn.meteor.spacecraft.proxy.xmlparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.proxy.xmlparser
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 13:52
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 13:52
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class CrawlerDefine {

    private String className;
    private String id;
    private List<Map<String,String>> paramList = new ArrayList<>();
    private String url;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Map<String, String>> getParamList() {
        return paramList;
    }

    public void setParamList(List<Map<String, String>> paramList) {
        this.paramList = paramList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CrawlerDefine{" +
                "className='" + className + '\'' +
                ", id='" + id + '\'' +
                ", paramList=" + paramList +
                ", url='" + url + '\'' +
                '}';
    }
}
