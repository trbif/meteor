package cn.meteor.consumer.service;

import cn.meteor.consumer.bean.NewsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Service
public class MemberService {

    @Autowired
    RestTemplate restTemplate;

    public List<String> getOrderByUserList() {
        return restTemplate.getForObject("http://client-member/getUserList", List.class);
    }

    public List<NewsBean> getNewsList(long start, long end) {
        Map<String,String> info = new HashMap<String,String>();
        info.put("start",""+start);
        info.put("end",""+end);
        return restTemplate.getForObject("http://crawler-member/getNewsList?start={start}&end={end}", List.class, info);
    }

    public List<NewsBean> getNews() {
        return restTemplate.getForObject("http://crawler-member/getNews", List.class);
    }
}
