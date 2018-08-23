package cn.meteor.hubble.config.manager;

import cn.meteor.hubble.config.ServerConfig;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ProjectName: hubble
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/23 9:02
 * @Version: 1.0.0
 */
public class ServerConfigManager implements ConfigManager<ServerConfig> {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private final String configPath = "/hubbleConfig";

    @Override
    public ServerConfig loadConfig() {
        return null;
    }

    @Override
    public ServerConfig loadConfigFromDB() {
        ServerConfig serverConfig = new ServerConfig();
        serverConfig.setConfig("to set config");
        return serverConfig;
    }

    @Override
    public void updateConfigToDB(ServerConfig serverConfig) {

    }

    @Override
    public void syncConfigToZK(ServerConfig serverConfig) {
        if(serverConfig==null){
            LOG.error("serverConfig未初始化");
            return;
        }
        ZkClient zkClient = new ZkClient("localhost:2181");
        if(!zkClient.exists(configPath)){
            zkClient.createPersistent(configPath,true);
        }
        zkClient.writeData(configPath, serverConfig);
        zkClient.close();

    }
}
