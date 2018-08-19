package cn.mrcode.imooc.spring.cloud.order.message;

import cn.mrcode.imooc.spring.cloud.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;

/**
 * ${todo}
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/18 23:49
 */

public class StreamReceiverTest extends OrderApplicationTests {
    @Autowired
    private StreamClient streamClient;

    @Test
    public void send() {
        String msg = "now:" + new Date();
        streamClient.input().send(MessageBuilder.withPayload(msg).build());
    }
}