package cn.meteor.hubble.config.manager;

/**
 * @ProjectName: hubble
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/23 9:03
 * @Version: 1.0.0
 */
public interface ConfigManager<T> {
    public T loadConfig();
    public T loadConfigFromDB();
    public void updateConfigToDB(T t);
    public void syncConfigToZK(T t);
}
