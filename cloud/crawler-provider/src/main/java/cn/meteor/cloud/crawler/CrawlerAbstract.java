package cn.meteor.cloud.crawler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.crawler
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 10:53
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/9 10:53
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public abstract class CrawlerAbstract implements Crawler {
    protected static String encode = "utf-8";

    /*
     * 将时间戳转换为时间
     */
    protected String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
