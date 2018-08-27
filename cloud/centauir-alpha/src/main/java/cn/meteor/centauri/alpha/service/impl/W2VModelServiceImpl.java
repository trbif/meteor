package cn.meteor.centauri.alpha.service.impl;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.bean.UserVectorBean;
import cn.meteor.centauri.alpha.bean.W2VModelBean;
import cn.meteor.centauri.alpha.mapper.UserMapper;
import cn.meteor.centauri.alpha.mapper.UserVectorMapper;
import cn.meteor.centauri.alpha.mapper.W2VModelMapper;
import cn.meteor.centauri.alpha.service.W2VModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:55
 * @Version: 1.0.0
 */
@Service
public class W2VModelServiceImpl implements W2VModelService {

    @Resource
    W2VModelMapper w2VModelMapper;
    @Resource
    UserVectorMapper userVectorMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public W2VModelBean getMostAccurateModel() {
        return w2VModelMapper.getMostAccurateModel();
    }

    @Override
    public W2VModelBean getAvailableModel() {
        W2VModelBean w2VModelBean = w2VModelMapper.getRecentUsedModel();
        //返回最近使用的模型，如果没有最近使用过的（项目初始化时，使用分数最高的项目）
        if(w2VModelBean.getModelRecentUsedTime()>0)
            return  w2VModelBean;
        else
            return w2VModelMapper.getMostAccurateModel();
    }

    @Override
    public void updateRecentUsedTime(W2VModelBean bean) {
        w2VModelMapper.uptadeRecentUsedTime(bean);
    }

    @Override
    public void insert(W2VModelBean bean) {
        w2VModelMapper.insert(bean);
    }

    @Override
    public void uptadeOrInsertUserVector(UserVectorBean bean) {
        userVectorMapper.uptadeOrInsert(bean);
    }

    @Override
    public UserVectorBean getUserVectorByUserid(long userid) {
        return userVectorMapper.getByUserid(userid);
    }

    @Override
    public List<UserBean> arrangeUserList(long lastlogin){
        return userMapper.getListByLoginTime(lastlogin);
    }

}
