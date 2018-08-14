package cn.meteor.cloud.service.impl;

import cn.meteor.cloud.mapper.NewsMapper;
import cn.meteor.cloud.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: crawler-provider
 * @Package: cn.meteor.cloud.service.impl
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 9:47
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/9 9:47
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    NewsMapper newsMapper;

    @Override
    public void getListToTrain() {

    }
}
