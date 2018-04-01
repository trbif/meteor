package cloudatlas.crawler.controller;

import cloudatlas.crawler.crawler.XMFeedbackCrawler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlerController {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot 2.0!";
    }

    @RequestMapping("/crawler")
    public String crawler() {
        for(int i=0;i<XMFeedbackCrawler.FEEDBACK_TYPE.length;i++){
            final String type = XMFeedbackCrawler.FEEDBACK_TYPE[i];
            new Thread(new Runnable() {
                @Override
                public void run() {
                    XMFeedbackCrawler crawler = new XMFeedbackCrawler();
                    crawler.seizeComments(type);
                }
            }).start();
        }
        return "Hello Spring Boot 2.0!";
    }
}
