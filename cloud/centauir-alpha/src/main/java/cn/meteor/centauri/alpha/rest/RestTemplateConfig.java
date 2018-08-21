package cn.meteor.centauri.alpha.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: data-provider
 * @Description: 本打算通过resttemplate来实现crawler的rpc调用，但毕竟封装层次高，于是采用网络层次较低的dubbo来完成rpc
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 16:50
 * @Version: 1.0.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }
}