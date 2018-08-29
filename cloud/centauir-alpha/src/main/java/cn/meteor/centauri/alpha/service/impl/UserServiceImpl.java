package cn.meteor.centauri.alpha.service.impl;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.bean.UserVectorBean;
import cn.meteor.centauri.alpha.mapper.UserMapper;
import cn.meteor.centauri.alpha.mapper.UserVectorMapper;
import cn.meteor.centauri.alpha.returnmsg.BeanEmptyException;
import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.centauri.alpha.service.NewsService;
import cn.meteor.centauri.alpha.service.UserService;
import cn.meteor.centauri.alpha.workbox.utils.TimeUtil;
import cn.meteor.spacecraft.bean.NewsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 8:48
 * @Version: 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Resource
    UserMapper userMapper;
    @Resource
    UserVectorMapper userVectorMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public UserBean getUserList(String userName) {
        return userMapper.find(userName);
    }

    /*
    * 根据用户id获取用户向量
    * 未对redis进行更新设计
    */
    @Override
    public UserVectorBean getUserVectorBeanByUserid(UserBean userBean) throws BeanEmptyException {
        UserVectorBean userVectorBean = (UserVectorBean)redisTemplate.opsForValue().get(userBean.getId());
        if(userVectorBean==null){
            userVectorBean = userVectorMapper.getByUserid(userBean.getId());
            redisTemplate.opsForValue().set(userBean.getId(),userVectorBean,60*5,TimeUnit.SECONDS);
            LOG.info("redisTemplate:set{}",userBean.getId());
        }
        LOG.info("userVectorBean:{}",userVectorBean);
        if(userVectorBean==null) throw new BeanEmptyException(new StringBuilder()
                .append("userID:")
                .append(userBean.getId())
                .append(" 不存在")
                .toString());
        return userVectorBean;
    }

    @Override
    public void updateOrInsertUserVectorBean(UserVectorBean userVectorBean) {
        userVectorMapper.uptadeOrInsert(userVectorBean);
    }

    @Override
    public List<UserBean> getUserListByLoginTime(long lastlogin) throws BeanEmptyException {
        List<UserBean> userBeanList = userMapper.getListByLoginTime(lastlogin);
        if(userBeanList==null) throw new BeanEmptyException(new StringBuilder()
                .append(TimeUtil.stampToDate(lastlogin))
                .append(" 之前登录的用户列表不存在")
                .toString());
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
