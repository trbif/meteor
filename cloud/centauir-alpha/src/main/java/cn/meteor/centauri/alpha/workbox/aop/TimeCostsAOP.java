package cn.meteor.centauri.alpha.workbox.aop;

import cn.meteor.centauri.alpha.workbox.annotation.TimeCosts;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ProjectName: data-provider
 * @Description: 拦截TestCosts注解并输出耗时
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/20 9:19
 * @Version: 1.0.0
 */
@Aspect
@Component
public class TimeCostsAOP {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Pointcut("@annotation(cn.meteor.centauri.alpha.workbox.annotation.TimeCosts)")
    public void annotationCut(){};


    @Around("annotationCut()")
    public void BeforeAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature=(MethodSignature) proceedingJoinPoint.getSignature();
        Method method=signature.getMethod();
        TimeCosts costs=method.getAnnotation(TimeCosts.class);
        long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        long end = System.currentTimeMillis();
        LOG.info("{}方法耗时{}ms",costs.name(),end-start);
    }
}
