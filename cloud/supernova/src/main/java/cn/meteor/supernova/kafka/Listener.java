package cn.meteor.supernova.kafka;

import cn.meteor.centauri.alpha.bean.UserAction;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @ProjectName: supernova
 * @Description: kafka监听器
 * @Author: Daivd Zhang
 * @CreateDate: 2018/9/2
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Listener {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(topics = {"user_action"})
    public void listen(ConsumerRecord<?, ?> record) {
        LOG.info("kafka的key: " + record.key());
        LOG.info("kafka的value: " + record.value().toString());
    }
}
