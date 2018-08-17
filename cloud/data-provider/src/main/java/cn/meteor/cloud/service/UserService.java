package cn.meteor.cloud.service;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.returnmsg.ReturnMsg;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.data.service
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 8:35
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 8:35
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface UserService {
    public UserBean getUserList(String userName);
    public List<NewsBean> getUserStableList(UserBean userBean);
    public List<NewsBean> getUserCurrentList(UserBean userBean);
    public List<NewsBean> getUserIntendedList(UserBean userBean);
    public List<UserBean> getUserListByLoginTime(long lastlogin);
    public ReturnMsg logup(UserBean userBean);
}
