package cn.meteor.cloud.redis;

import cn.meteor.DataProviderApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.redis
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 12:47
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 12:47
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataProviderApplication.class)
public class RedisConfigTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void testPipeLine(){
        redisTemplate.opsForValue().set("a",1);
        redisTemplate.opsForValue().set("b",2);
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.openPipeline();
                for (int i = 0;i < 10;i++){
                    redisConnection.incr("a".getBytes());
                }
                System.out.println("a:"+redisTemplate.opsForValue().get("a"));
                redisTemplate.opsForValue().set("c",3);
                for(int j = 0;j < 20;j++){
                    redisConnection.incr("b".getBytes());
                }
                System.out.println("b:"+redisTemplate.opsForValue().get("b"));
                System.out.println("c:"+redisTemplate.opsForValue().get("c"));
                redisConnection.closePipeline();
                return null;
            }
        });
        System.out.println("b:"+redisTemplate.opsForValue().get("b"));
        System.out.println("a:"+redisTemplate.opsForValue().get("a"));
    }

    @Test
    public void testMulti(){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        redisTemplate.setEnableTransactionSupport(true);
        //在未提交之前是获取不到值得，同时再次循环报错
        while (true){
            redisTemplate.watch("multiTest");
            redisTemplate.multi();
            valueOperations.set("multiTest",1);
            valueOperations.increment("multiTest",2);
            Object o = valueOperations.get("multiTest");
            List list = redisTemplate.exec();
            System.out.println(list);
            System.out.println(o);
        }

    }

}