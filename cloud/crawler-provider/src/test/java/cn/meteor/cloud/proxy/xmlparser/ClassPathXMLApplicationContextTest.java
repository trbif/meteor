package cn.meteor.cloud.proxy.xmlparser;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

//import org.apache.log4j.Logger;

/**
 * @Description: spring中的注解原理
 * @ClassName: ClassPathXMLApplicationContext
 * @Project: spring-aop
 * @Author: zxf
 * @Date: 2011-6-3
 */
@ActiveProfiles("test")
public class ClassPathXMLApplicationContextTest {
    @Test
    public void testClassPathXMLApplicationContext(){
        ClassPathXMLApplicationContext context = new ClassPathXMLApplicationContext();
        System.out.println(context.readXML("crawlers.xml"));
    }
}