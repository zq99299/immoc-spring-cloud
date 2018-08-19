package cn.mrcode.imooc.spring.cloud.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/18 23:42
 */
@Component
@EnableBinding({StreamClient.class})
@Slf4j
public class StreamReceiver {
    @StreamListener(StreamClient.INPUT)
    public void process(String message) {
        log.info("StreamListener process message {}", message);
    }

    @StreamListener(StreamClient.PERSON_INPUT)
    public void process(Person person) {
        log.info("StreamListener process message person {}", person);
    }
// 不能多个处理方法绑定同一个队列
//    @StreamListener(StreamClient.PERSON_INPUT)
//    @SendTo(StreamClient.INPUT)
    public String processAndReply(Person person) {
        log.info("StreamListener process message person {}", person);
        return "ok";
    }
}
