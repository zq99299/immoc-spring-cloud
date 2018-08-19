package cn.mrcode.imooc.spring.cloud.product.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/19 10:15
 */
public interface StreamClientOutput {
    String OUTPUT = "myMessage";
    String PERSON_OUTPUT = "myPerson";

    @Output(OUTPUT)
    MessageChannel output();

    @Output(PERSON_OUTPUT)
    MessageChannel personOutput();
}
