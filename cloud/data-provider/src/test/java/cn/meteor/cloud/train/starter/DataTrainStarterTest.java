package cn.meteor.cloud.train.starter;

import cn.meteor.DataProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.train.starter
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 16:08
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 16:08
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataProviderApplication.class)
public class DataTrainStarterTest {

    @Autowired
    DataTrainStarter dataTrainStarter;

    @Test
    public void testDataTrainStarter(){
        dataTrainStarter.train();
    }
}
