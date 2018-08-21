package cn.meteor.centauri.alpha.controller;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.oper.UserOper;
import cn.meteor.centauri.alpha.redis.RedisClient;
import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.centauri.alpha.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: data-provider
 * @Description: 其它验证用的controller
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/16 16:48
 * @Version: 1.0.0
 */
@RestController
@CacheConfig(cacheNames = "users")
public class ClientController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

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
