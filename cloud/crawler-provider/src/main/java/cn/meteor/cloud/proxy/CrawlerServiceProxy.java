package cn.meteor.cloud.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.proxy
 * @ClassName: ${TYPE_NAME}
 * @Description: 爬虫动态代理类
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/8 8:04
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/8 8:04
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class CrawlerServiceProxy implements InvocationHandler {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private Object target;

    public CrawlerServiceProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获得将来所调用方法的名字
        String methodName = method.getName();
        // 用日志记录输出一下
        LOG.info(methodName+"is invocation");
        // 用反射的方式去调用将来需要真正调用的方法.
        Object o = method.invoke(target, args);

        return o;
    }
}
