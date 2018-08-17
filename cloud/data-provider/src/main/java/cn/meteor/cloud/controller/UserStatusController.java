package cn.meteor.cloud.controller;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.returnmsg.ReturnMsg;
import cn.meteor.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.controller
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 16:56
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/17 16:56
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RestController("/userstatus")
public class UserStatusController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/logup")
    public ReturnMsg logup(HttpServletRequest request) {
        UserBean userBean = new UserBean();
        return userService.logup(userBean);
    }

    @RequestMapping(value = "/login")
    public ReturnMsg login(){
        return null;
    }
}
