package cn.meteor.centauri.alpha.train;

import cn.meteor.AlphaCentauriProviderApplication;
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
 * @CreateDate: 2018/8/20 15:09
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/20 15:09
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlphaCentauriProviderApplication.class)
public class W2VModelTest {
    @Autowired
    W2VProvider w2VProvider;

    @Test
    public void testModel(){
        System.out.println(w2VProvider.getCurrentModel().getWordVector("Intenet"));
        System.out.println(w2VProvider.getCurrentModel().getWordVector("公司"));
        System.out.println(w2VProvider.getCurrentModel().getWordVector("CPU"));
        System.out.println(w2VProvider.getCurrentModel().getWordVector("未来"));
    }

}
