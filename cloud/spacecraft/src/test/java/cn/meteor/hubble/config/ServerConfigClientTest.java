package cn.meteor.hubble.config;

import cn.meteor.hubble.config.client.ServerConfigClient;
import org.junit.Test;

/**
 * @ProjectName: spacecraft
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/23 9:28
 * @Version: 1.0.0
 */
public class ServerConfigClientTest {

    @Test
    public void testClient(){
        ServerConfigClient serverConfigClient = new ServerConfigClient();
        System.out.println(serverConfigClient.getConfig());
    }
}
