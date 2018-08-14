package cn.meteor.cloud.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.data.redis
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 11:19
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 11:19
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Component
public class RedisClient {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CacheManager cacheManager;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public void test(){
        redisTemplate.opsForValue().set("data","data");
        String redisOut = (String) redisTemplate.opsForValue().get("user::aa");
        LOG.info("redisOut{}",redisOut);
    }
}
