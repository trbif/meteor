package cn.meteor.centauri.alpha.service;

import cn.meteor.AlphaCentauriProviderApplication;
import cn.meteor.centauri.alpha.bean.UserBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.service
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/20 13:45
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/20 13:45
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlphaCentauriProviderApplication.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testInsert(){
        UserBean userBean = new UserBean();
        userBean.setUsername("tt");
        userBean.setPassword("hh");
        userService.insert(userBean);
        System.out.println(userBean.getId());
    }
}
