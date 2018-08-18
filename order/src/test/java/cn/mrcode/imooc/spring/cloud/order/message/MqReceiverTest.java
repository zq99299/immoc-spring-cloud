package cn.mrcode.imooc.spring.cloud.order.message;

import cn.mrcode.imooc.spring.cloud.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * ${todo}
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/18 22:23
 */
public class MqReceiverTest extends OrderApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", new Date());
    }

    @Test
    public void computerSend() {
        amqpTemplate.convertAndSend("myExchange", "computer", new Date());
    }
}