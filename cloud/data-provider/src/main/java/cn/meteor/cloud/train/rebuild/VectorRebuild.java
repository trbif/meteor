package cn.meteor.cloud.train.rebuild;

import java.util.concurrent.Callable;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.train.rebuild
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 10:09
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/17 10:09
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface VectorRebuild extends Callable {
    public void rebuild();
}
