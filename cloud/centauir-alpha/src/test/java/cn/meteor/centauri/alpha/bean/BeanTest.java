package cn.meteor.centauri.alpha.bean;

import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.spacecraft.bean.NewsBean;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.bean
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/17 8:06
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/17 8:06
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class BeanTest {

    @Test
    public void testBean(){
        NewsBean bean = new NewsBean();
        bean.setMd5("~~");
        System.out.println(bean);
        System.out.println(new ReturnMsg.Builder().
                setErrorMsg("success").
                setAccuracy(1.0).
                build());
        System.out.println(JSON.parseObject(new ReturnMsg.Builder().
                setErrorMsg("success").
                setAccuracy(1.0).
                build().toString()).get("errorMsg"));
        Float[] vector = {1.0f,2.0f,3.0f};
        List<Float> list = JSON.parseArray(Arrays.asList(vector).toString(),Float.class);
        System.out.println(list);
        Float[] result = list.toArray(new Float[list.size()]);
        for(float f:result){
            System.out.println(f);
        }
    }
}
