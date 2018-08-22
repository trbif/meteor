package cn.meteor.centauri.alpha.service;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.bean.UserVectorBean;
import cn.meteor.centauri.alpha.bean.W2VModelBean;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:54
 * @Version: 1.0.0
 */
public interface W2VModelService {
    public W2VModelBean getMostAccurateModel();
    public void insert(W2VModelBean bean);
    public void uptadeOrInsertUserVector(UserVectorBean bean);
    public UserVectorBean getUserVectorByUserid(long userid);
    public List<UserBean> arrangeUserList(long lastlogin);
}
