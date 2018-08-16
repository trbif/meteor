package cn.meteor.cloud.proxy;

import cn.meteor.cloud.crawler.Crawler;
import cn.meteor.cloud.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.proxy
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 8:36
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 8:36
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class CrawlerGenInstance {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private static Object lock = new Object();
    private static CrawlerGenInstance instance = null;

    public static CrawlerGenInstance getInstance(){
        if(instance==null){
            synchronized (lock){
                if(instance==null){
                    return new CrawlerGenInstance();
                }else{
                    return instance;
                }
            }
        }else{
            return instance;
        }
    }

    public Crawler get(String className, NewsService newsService) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> crawlerClass = Class.forName(className);
        Object crawlerObject =  crawlerClass.newInstance();

        Class objectClass = crawlerObject.getClass();
        //获得目标对象的类加载器对象
        ClassLoader classLoader = objectClass.getClassLoader();

        //获得目标对象所实现的所有接口
        Class[] interfaces = objectClass.getInterfaces();

        //获得一个InvocationHandler接口的实现类对象,并把目标对象传进去
        InvocationHandler crawlerHandler = new CrawlerServiceProxy(crawlerObject);

        //参数1 目标对象的类加载器对象
        //参数2 目标对象所实现的所有接口. Class类型数组
        //参数3 InvocationHandler接口的实现类对象
        Crawler crawler = (Crawler)Proxy.newProxyInstance(classLoader, interfaces, crawlerHandler);
        crawler.setNewsService(newsService);
        return crawler;
    }
}
