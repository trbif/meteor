package cn.meteor.centauri.alpha.train;

import cn.meteor.AlphaCentauriProviderApplication;
import cn.meteor.centauri.alpha.train.word2vec.vec.VectorModel;
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
public class W2VModelTest {

    @Test
    public void testModel(){
        String modelPath = "D:/w2vmodel/1534940140167_10.mod";
        VectorModel model = VectorModel.loadFromFile(modelPath);
        System.out.println(model.getWordVector("Intenet"));
        System.out.println(model.getWordVector("公司"));
        System.out.println(model.getWordVector("手机"));
        System.out.println(model.getWordVector("电影"));
        System.out.println(model.similar("手机"));

    }

}
