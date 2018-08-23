package cn.meteor.hubble.config.client;

/**
 * @ProjectName: hubble
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/23 9:03
 * @Version: 1.0.0
 */
public interface ConfigClient<T> {
    public T getConfig();
}
