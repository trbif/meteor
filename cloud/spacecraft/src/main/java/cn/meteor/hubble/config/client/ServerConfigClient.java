package cn.meteor.hubble.config.client;

import cn.meteor.hubble.config.ServerConfig;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * @ProjectName: hubble
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/23 9:02
 * @Version: 1.0.0
 */
public class ServerConfigClient implements ConfigClient<ServerConfig> {

    private final String configPath = "/hubbleConfig";
    private ServerConfig serverConfig;

    @Override
    public ServerConfig getConfig() {
        ZkClient zk = new ZkClient("localhost:2181");
        serverConfig = (ServerConfig)zk.readData(configPath);
        System.out.println("加载到配置："+serverConfig.toString());

        //监听配置文件修改
        zk.subscribeDataChanges(configPath, new IZkDataListener(){
            @Override
            public void handleDataChange(String arg0, Object arg1)
                    throws Exception {
                serverConfig = (ServerConfig) arg1;
                System.out.println("监听到配置文件被修改："+serverConfig.toString());
            }

            @Override
            public void handleDataDeleted(String arg0) throws Exception {
                serverConfig = null;
                System.out.println("监听到配置文件被删除");
            }

        });
        return serverConfig;
    }

}
