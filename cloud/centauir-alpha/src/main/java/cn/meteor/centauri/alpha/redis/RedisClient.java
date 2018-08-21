package cn.meteor.centauri.alpha.redis;

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
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 11:19
 * @Version: 1.0.0
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
