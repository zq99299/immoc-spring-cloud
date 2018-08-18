package cn.mrcode.imooc.spring.cloud.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * mq接收
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/18 22:21
 */
@Slf4j
@Component
public class MqReceiver {
    //    @RabbitListener(queues = "myQueue")
//    //当队列不存在的时候，自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"), exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("接收到消息 myQueue：{}", message);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myExchange"),
            key = "computer",
            value = @Queue("computerOrderQueue")
    ))
    public void computerProcess(String message) {
        log.info("接收到消息 computerOrderQueue：{}", message);
    }
}
