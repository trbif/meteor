package cn.meteor.centauri.alpha.train.rebuild;

import java.util.concurrent.Callable;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 10:09
 * @Version: 1.0.0
 */
public interface VectorRebuild extends Callable {
    public void rebuild();
}
