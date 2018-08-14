package cn.meteor.cloud.train.starter;

import cn.meteor.cloud.bean.NewsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ProjectName: data-provider
 * @Package: cn.meteor.cloud.data.train.starter
 * @ClassName: ${TYPE_NAME}
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/10 14:15
 * @UpdateUser: Daivd Zhang
 * @UpdateDate: 2018/8/10 14:15
 * @UpdateRemark: The modified content
 * @Version: 1.0.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Component
public class DataTrainStarter {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

//
//    public List<NewsBean> getNewsList(long start, long end) {
//        Map<String,String> info = new HashMap<String,String>();
//        info.put("start",""+start);
//        info.put("end",""+end);
//        return restTemplate.getForObject("http://crawler-member/getNewsList", List.class, info);
//    }

    public List<NewsBean> getNews() {
        return restTemplate.getForObject("http://crawler-member/getNews", List.class);
    }

    public void train(){
        LOG.info(getNews().toString());
    }
}
