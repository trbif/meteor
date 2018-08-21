package cn.meteor.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class GalaxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalaxyApplication.class, args);
    }

    /**
     * 必须加上，不然启动不了
     * @return
     */
    @Bean    //加入bean容器中
    @LoadBalanced
    //支持负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
