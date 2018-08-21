package cn.meteor.centauri.alpha.service.impl;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.bean.UserVectorBean;
import cn.meteor.centauri.alpha.mapper.UserMapper;
import cn.meteor.centauri.alpha.mapper.UserVectorMapper;
import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.centauri.alpha.service.NewsService;
import cn.meteor.centauri.alpha.service.UserService;
import cn.meteor.spacecraft.bean.NewsBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 8:48
 * @Version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserVectorMapper userVectorMapper;

    @Override
    public UserBean getUserList(String userName) {
        return userMapper.find(userName);
    }

    @Override
    public UserVectorBean getUserVectorBeanByUserid(UserBean userBean) {
        return userVectorMapper.getByUserid(userBean.getId());
    }

    @Override
    public void updateOrInsertUserVectorBean(UserVectorBean userVectorBean) {
        userVectorMapper.uptadeOrInsert(userVectorBean);
    }

    @Override
    public List<UserBean> getUserListByLoginTime(long lastlogin) {
        return userMapper.getListByLoginTime(lastlogin);
    }

    @Override
    public ReturnMsg logup(UserBean userBean) {
        userMapper.insert(userBean);
        return null;
    }

    @Override
    public long insert(UserBean userBean) {
        userMapper.insert(userBean);
        return userBean.getId();
    }

    @Override
    public ReturnMsg init(UserBean userBean,Float[] vector) {
        userMapper.insert(userBean);
        UserVectorBean userVectorBean = new UserVectorBean();
        userVectorBean.setUserid(userBean.getId());
        String vecStr = Arrays.asList(vector).toString();
        userVectorBean.setStablevector(vecStr);
        userVectorBean.setCurrentvector(vecStr);
        userVectorBean.setIntendedvector(vecStr);
        userVectorBean.setVersion("1.0.0");
        userVectorMapper.uptadeOrInsert(userVectorBean);
        return null;
    }

    @Override
    public ReturnMsg dislike(UserBean userBean,NewsBean newsBean) {
        return null;
    }

    @Override
    public ReturnMsg like(UserBean userBean,NewsBean newsBean) {
        return null;
    }

    @Override
    public List<NewsService> refresh(UserBean userBean) {
        return null;
    }
}
