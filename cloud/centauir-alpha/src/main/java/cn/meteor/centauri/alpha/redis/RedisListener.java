package cn.meteor.centauri.alpha.redis;

import cn.meteor.centauri.alpha.bean.UserBean;
import cn.meteor.centauri.alpha.oper.UserOper;
import cn.meteor.centauri.alpha.oper.impl.UserOperImpl;
import cn.meteor.centauri.alpha.redis.service.RedisQueue;
import cn.meteor.centauri.alpha.service.UserService;
import cn.meteor.centauri.alpha.train.W2VProvider;
import cn.meteor.spacecraft.bean.NewsBean;
import cn.meteor.spacecraft.dubbo.NewsConsumerService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: alpha-centauri
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/28 14:43
 * @Version: 1.0.0
 */
@Service
public class RedisListener implements InitializingBean {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserOper userOper;

    @Autowired
    RedisQueue redisQueue;

    @Override
    public void afterPropertiesSet() throws Exception {
        ListenerThread thread = new ListenerThread();
        thread.setDaemon(true);
        thread.start();
    }

    class ListenerThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String value = redisQueue.popMsg();
                    if (StringUtils.isNotEmpty(value)) {
                        String[] opers = value.split("||");
                        JSONObject params = JSON.parseObject(value);
                        String type = params.getString("type");
                        UserBean userBean = params.getObject("userBean",UserBean.class);
                        NewsBean newsBean = params.getObject("newsBean",NewsBean.class);
                        if(type.equals("like")){
                            userOper.like(userBean,newsBean);
                        }else{
                            LOG.info("nothing");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
