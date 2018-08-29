package cn.meteor.centauri.alpha.oper;

import cn.meteor.AlphaCentauriProviderApplication;
import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.returnmsg.BeanEmptyException;
import cn.meteor.spacecraft.bean.NewsBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.oper
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/20 11:13
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/20 11:13
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlphaCentauriProviderApplication.class)
public class UserOperTest {

    @Autowired
    UserOper userOper;

    @Test
    public void testInit(){
        UserBean userBean = new UserBean();
        userBean.setUsername("testInit");
        userBean.setPassword("test");
        userOper.init(userBean);
    }

    @Test
    public void testLike(){
        UserBean userBean = new UserBean();
        userBean.setId(1);
        NewsBean newsBean = new NewsBean();
        newsBean.setNewsCategory("CPU");
        try {
            userOper.like(userBean,newsBean);
        } catch (BeanEmptyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDislike(){
        UserBean userBean = new UserBean();
        userBean.setId(1);
        NewsBean newsBean = new NewsBean();
        newsBean.setNewsCategory("CPU");
        try {
            userOper.dislike(userBean,newsBean);
        } catch (BeanEmptyException e) {
            e.printStackTrace();
        }
    }
}
