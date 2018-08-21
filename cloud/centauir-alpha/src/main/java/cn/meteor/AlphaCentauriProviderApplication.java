package cn.meteor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDiscoveryClient
@EnableScheduling
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "cn.meteor.*")
public class AlphaCentauriProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaCentauriProviderApplication.class, args);
    }

}