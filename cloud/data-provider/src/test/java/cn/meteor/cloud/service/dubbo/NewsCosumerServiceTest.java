package cn.meteor.cloud.service.dubbo;

import cn.meteor.DataProviderApplication;
import cn.meteor.cloud.dubbo.NewsConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: meteor
 * @Package: cn.meteor.cloud.service.dubbo
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/13 15:06
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/13 15:06
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataProviderApplication.class)
public class NewsCosumerServiceTest {

    @Autowired
    NewsConsumerService newsConsumerService;

    @Test
    public void test(){
        System.out.println(newsConsumerService.getNewsList(1531885866000L,1631885866000L));
    }
}
