package cn.meteor.centauri.alpha.oper;


import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.centauri.alpha.service.NewsService;
import cn.meteor.spacecraft.bean.NewsBean;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/20 11:11
 * @Version: 1.0.0
 */
public interface UserOper {
    public ReturnMsg init(UserBean userBean);
    public ReturnMsg dislike(UserBean userBean,NewsBean newsBean);
    public ReturnMsg like(UserBean userBean,NewsBean newsBean);
    public List<NewsService> refresh(UserBean userBean);
}
