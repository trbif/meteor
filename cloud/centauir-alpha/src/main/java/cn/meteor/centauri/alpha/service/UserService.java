package cn.meteor.centauri.alpha.service;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.bean.UserVectorBean;
import cn.meteor.centauri.alpha.returnmsg.BeanEmptyException;
import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.spacecraft.bean.NewsBean;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 8:35
 * @Version: 1.0.0
 */
public interface UserService {
    public UserBean getUserList(String userName);
    public UserVectorBean getUserVectorBeanByUserid(UserBean userBean) throws BeanEmptyException;
    public void updateOrInsertUserVectorBean(UserVectorBean userVectorBean);
    public List<UserBean> getUserListByLoginTime(long lastlogin) throws BeanEmptyException;
    public ReturnMsg logup(UserBean userBean);
    public long insert(UserBean userBean);
    public ReturnMsg init(UserBean userBean,Float[] vector);
    public ReturnMsg dislike(UserBean userBean,NewsBean newsBean);
    public ReturnMsg like(UserBean userBean,NewsBean newsBean);
    public List<NewsService> refresh(UserBean userBean);
}
