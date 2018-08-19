package cn.mrcode.imooc.spring.cloud.order.controller;

import cn.mrcode.imooc.spring.cloud.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/19 9:57
 */
@RestController
@EnableBinding(StreamClient.class)
public class StreamController {
    @Autowired
    private StreamClient streamClient;

    @GetMapping("/send")
    public void send() {
        String msg = "now:" + new Date();
        streamClient.input().send(MessageBuilder.withPayload(msg).build());
    }
}
