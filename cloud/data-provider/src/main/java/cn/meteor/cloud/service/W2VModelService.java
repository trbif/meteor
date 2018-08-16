package cn.meteor.cloud.service;

import cn.meteor.cloud.bean.W2VModelBean;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.service
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:54
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 16:54
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface W2VModelService {
    public W2VModelBean getMostAccurateModel();
    public void insert(W2VModelBean bean);
}
