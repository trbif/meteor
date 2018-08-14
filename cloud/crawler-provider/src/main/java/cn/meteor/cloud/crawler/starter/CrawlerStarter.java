package cn.meteor.cloud.crawler.starter;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.crawler.Crawler;
import cn.meteor.cloud.proxy.CrawlerGenInstance;
import cn.meteor.cloud.proxy.xmlparser.ClassPathXMLApplicationContext;
import cn.meteor.cloud.proxy.xmlparser.CrawlerDefine;
import cn.meteor.cloud.service.CrawlerService;
import cn.meteor.cloud.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.crawler.starter
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 9:40
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 9:40
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Component
public class CrawlerStarter {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
//    @Qualifier("cn.meteor.cloud.service.impl.CrawlerServiceImpl")
    CrawlerService crawlerService;
    @Autowired
    NewsService newsService;


    private Map<String,CrawlerDefine> crawlers = new HashMap<String,CrawlerDefine>();

    //hashmap clear原理  通过断开与对象的关系连接，利用jvm的可达性垃圾清理机制，完成clear操作
    /*public void clear() {
        Node<K,V>[] tab;
        modCount++;
        if ((tab = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }*/

    //暂时没有解决xml内存没有替换问题
    public void reload(){
        crawlers.clear();
        ClassPathXMLApplicationContext context = new ClassPathXMLApplicationContext();
        for(CrawlerDefine defines:context.readXML("crawlers.xml")){
            LOG.info("id:{}",defines.getId());
            crawlers.put(defines.getClassName(),defines);
        }
    }

    @Scheduled(cron = "0 0/5 * * * ?")
    public void startCrawler(){
        reload();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(Map.Entry<String,CrawlerDefine> kv:crawlers.entrySet()){
            CrawlerGenInstance instance = CrawlerGenInstance.getInstance();
            Crawler crawler = null;
            try {
                crawler = instance.get((String)kv.getKey(),newsService);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            if (crawler!=null) {
                for(Map<String,String> paramsMap:kv.getValue().getParamList()){
                    String url = kv.getValue().getUrl();
                    for(Map.Entry<String,String> param:paramsMap.entrySet()){
                        if(param.getValue()==null){
                            if(param.getKey().lastIndexOf("_ms@")!=-1){
                                url = url.replace(param.getKey(), ""+Calendar.getInstance().getTimeInMillis());
                            }else if(param.getKey().lastIndexOf("_s@")!=-1){
                                url = url.replace(param.getKey(), ""+Calendar.getInstance().getTimeInMillis()/1000);
                            }
                        }else {
                            url = url.replace(param.getKey(), param.getValue());
                        }
                    }
                    LOG.info("finalURL:{}",url);
                    cachedThreadPool.execute(new CrawlerThread(crawler,url,newsService));
                    LOG.info("{}启动",kv.getKey());
                }
            }
        }
    }

    class CrawlerThread extends Thread{
        private NewsService newsService;
        private Crawler crawler;
        private String url;
        public CrawlerThread(Crawler crawler,String url,NewsService newsService){
            this.crawler = crawler;
            this.url = url;
            this.newsService = newsService;
        }
        public void run(){
            for(NewsBean newsBean:crawler.seize(url)){
//                if(newsService.newsDuplicatedList(newsBean.getMd5()).size()==0)
//                    newsService.insert(newsBean);
            }
        }
    }
}
