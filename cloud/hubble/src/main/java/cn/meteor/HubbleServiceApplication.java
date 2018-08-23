package cn.meteor;

import cn.meteor.hubble.config.ServerConfig;
import cn.meteor.hubble.config.manager.ServerConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HubbleServiceApplication {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    public static void main(String[] args) {
        SpringApplication.run(HubbleServiceApplication.class, args);

        //zookeepr配置管理中心启动
        ServerConfigManager serverConfigManager = new ServerConfigManager();
        ServerConfig serverConfig = serverConfigManager.loadConfigFromDB();
        serverConfigManager.syncConfigToZK(serverConfig);

    }
}
