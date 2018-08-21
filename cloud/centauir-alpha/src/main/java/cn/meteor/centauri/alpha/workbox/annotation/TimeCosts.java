package cn.meteor.centauri.alpha.workbox.annotation;

import java.lang.annotation.*;

/**
 * @ProjectName: data-provider
 * @Description: 对需要输出执行时长的函数进行标注
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/20 9:18
 * @Version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeCosts {
    String name();
}
