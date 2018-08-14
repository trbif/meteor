package cn.meteor.cloud.controller;

import cn.meteor.cloud.bean.NewsBean;
import cn.meteor.cloud.bean.UserBean;
import cn.meteor.cloud.dubbo.NewsConsumerService;
import cn.meteor.cloud.redis.RedisClient;
import cn.meteor.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@ComponentScan({"cn.meteor.cloud.service"})
//@MapperScan({"cn.meteor.cloud.mapper"})
@CacheConfig(cacheNames = "users")
public class ClientController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

//    @Value("${server.port}")
//    private String serverport;

    @Autowired
    UserService userService;

    @Cacheable(value="cacheMy",key ="#userName")
    @RequestMapping("/getUser")
    public UserBean getUser(@RequestParam(required=true)String userName) {
        return userService.getUserList(userName);
    }

/*    @CachePut(key = "#p0")
    @Update("update user set name=#{name} where id=#{id}")
    void updataById(@Param("id")String id,@Param("name")String name);

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    @Delete("delete from user where id=#{id}")
    void deleteById(@Param("id")String id);*/

    @RequestMapping("/user")
    public UserBean user() {
        return userService.getUserList("aa");
    }

    @Autowired
    RedisClient redisClient;

    @RequestMapping("/getRedis")
    public String getRedis() {
        redisClient.test();
        return "";
    }
}
