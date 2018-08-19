package cn.mrcode.imooc.spring.cloud.product.controller;

import cn.mrcode.imooc.spring.cloud.product.message.Person;
import cn.mrcode.imooc.spring.cloud.product.message.StreamClientOutput;
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
@EnableBinding(StreamClientOutput.class)
public class StreamController {
    @Autowired
    private StreamClientOutput streamClientOutput;

    @GetMapping("/send")
    public void send() {
        String msg = "now:" + new Date();
        streamClientOutput.output().send(MessageBuilder.withPayload(msg).build());
    }

    @GetMapping("/send/person")
    public void sendPerson() {
        Person person = new Person("mrcode", 18);
        streamClientOutput.personOutput().send(MessageBuilder.withPayload(person).build());
    }
}
