package cn.meteor.centauri.alpha.service.impl;

import cn.meteor.centauri.alpha.mapper.NewsMapper;
import cn.meteor.centauri.alpha.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: crawler-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/9 9:47
 * @Version: 1.0.0
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    NewsMapper newsMapper;

    @Override
    public void getListToTrain() {

    }
}
