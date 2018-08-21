package cn.meteor.galaxy.service;

import cn.meteor.centauri.alpha.returnmsg.ReturnMsg;
import cn.meteor.spacecraft.bean.NewsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Service
public class CentauriAlphaService {

    @Autowired
    RestTemplate restTemplate;

    public ReturnMsg init(String userName,String password) {
        Map<String,String> info = new HashMap<String,String>();
        info.put("userName",userName);
        info.put("password",password);
        return restTemplate.getForObject("http://data-member/init?userName={userName}&password={password}", ReturnMsg.class, info);
    }

    public ReturnMsg like(long userID, String newsCategory) {
        Map<String,String> info = new HashMap<String,String>();
        info.put("userID",""+userID);
        info.put("newsCategory",newsCategory);
        return restTemplate.getForObject("http://data-member/like?userID={userID}&newsCategory={newsCategory}", ReturnMsg.class, info);
    }

    public ReturnMsg dislike(long userID, String newsCategory) {
        Map<String,String> info = new HashMap<String,String>();
        info.put("userID",""+userID);
        info.put("newsCategory",newsCategory);
        return restTemplate.getForObject("http://data-member/dislike?userID={userID}&newsCategory={newsCategory}", ReturnMsg.class, info);
    }

    public List<NewsBean> refresh(long userID) {
        Map<String,String> info = new HashMap<String,String>();
        info.put("userID",""+userID);
        return restTemplate.getForObject("http://data-member/refresh?userID={userID}", List.class, info);
    }
}
