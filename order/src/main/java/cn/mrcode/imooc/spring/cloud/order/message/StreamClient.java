package cn.mrcode.imooc.spring.cloud.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/18 23:39
 */
public interface StreamClient {
    String INPUT = "myMessage";
    String PERSON_INPUT = "myPerson";

    @Input(INPUT)
    SubscribableChannel input();

    // 注意：在同一个应用中，不能存在两个myMessage的实例
    // 测试的时候是不能这样写的。启动就会报错，已经存在了一个myMessage实例
    // 发送的最后写在了另外一个程序中
//    @Output(INPUT)
//    MessageChannel output();

    @Input(PERSON_INPUT)
    SubscribableChannel personInput();
}
