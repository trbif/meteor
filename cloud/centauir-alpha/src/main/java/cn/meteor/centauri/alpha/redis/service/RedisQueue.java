package cn.meteor.centauri.alpha.redis.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: alpha-centauri
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/28 13:57
 * @Version: 1.0.0
 */
@Service
public class RedisQueue implements InitializingBean {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${server.port}")
    public String serverPort;

    @Autowired
    RedisTemplate redisTemplate;
    BoundListOperations<String, String> listRedisTemplate;

    public void pushMsg(String value) {
        listRedisTemplate.leftPush(value);
        LOG.info("RedisQueue加入数据：{}",value);
    }

    public String popMsg(){
        String value = listRedisTemplate.rightPop();
        if(StringUtils.isNotEmpty(value)) LOG.info("RedisQueue取出数据：{}",value);
        return value;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        listRedisTemplate = redisTemplate.boundListOps(serverPort+"-RedisQueue");
        LOG.info("listRedisTemplate size:{}",listRedisTemplate.size());
    }
}
