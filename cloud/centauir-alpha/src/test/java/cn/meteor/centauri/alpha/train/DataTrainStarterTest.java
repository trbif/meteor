package cn.meteor.centauri.alpha.train;

import cn.meteor.AlphaCentauriProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ProjectName: data-provider
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 16:08
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlphaCentauriProviderApplication.class)
public class DataTrainStarterTest {

    @Autowired
    DataTrainStarter dataTrainStarter;

    @Test
    public void testDataTrainStarter(){
        dataTrainStarter.train();
    }
}
