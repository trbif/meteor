package cn.meteor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HubbleServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HubbleServiceApplication.class, args);
    }
}
