package cn.meteor.cloud.train;

import cn.meteor.DataProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.train
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 15:38
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/17 15:38
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataProviderApplication.class)
public class W2VProviderTest {

    @Autowired
    W2VProvider w2VProvider;

    @Test
    public void testUserVectorRebuild(){
        w2VProvider.userVectorRebuild();
    }
}
