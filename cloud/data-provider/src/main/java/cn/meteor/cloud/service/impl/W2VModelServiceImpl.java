package cn.meteor.cloud.service.impl;

import cn.meteor.cloud.bean.W2VModelBean;
import cn.meteor.cloud.mapper.W2VModelMapper;
import cn.meteor.cloud.service.W2VModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.service.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:55
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/16 16:55
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class W2VModelServiceImpl implements W2VModelService {

    @Resource
    W2VModelMapper w2VModelMapper;

    @Override
    public W2VModelBean getMostAccurateModel() {
        return w2VModelMapper.getMostAccurateModel();
    }

    @Override
    public void insert(W2VModelBean bean) {
        w2VModelMapper.insert(bean);
    }
}
