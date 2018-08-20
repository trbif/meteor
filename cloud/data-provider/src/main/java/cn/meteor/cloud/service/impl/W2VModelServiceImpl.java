package cn.meteor.cloud.service.impl;

import cn.meteor.cloud.bean.CategoryBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.bean.UserVectorBean;
import cn.meteor.cloud.bean.W2VModelBean;
import cn.meteor.cloud.mapper.CategoryMapper;
import cn.meteor.cloud.mapper.UserMapper;
import cn.meteor.cloud.mapper.UserVectorMapper;
import cn.meteor.cloud.mapper.W2VModelMapper;
import cn.meteor.cloud.service.UserService;
import cn.meteor.cloud.service.W2VModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
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
    @Resource
    CategoryMapper categoryMapper;

    @Override
    public W2VModelBean getMostAccurateModel() {
        return w2VModelMapper.getMostAccurateModel();
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

    @Override
    public List<CategoryBean> getAllCategory() {
        return categoryMapper.findAll();
    }
}
