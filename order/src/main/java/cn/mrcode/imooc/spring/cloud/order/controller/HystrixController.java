package cn.mrcode.imooc.spring.cloud.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/19 21:14
 */
@RestController
@RequestMapping("/hystrix")
// 当有多个需要降级的时候，可以使用一个默认的降级服务
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {
    private RestTemplate restTemplate = new RestTemplate();

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")}
            ,
            fallbackMethod = "fallback"
    )
    @GetMapping("/product/list")
    public String test1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        String result = restTemplate.getForObject("http://127.0.0.1:8080/product/list", String.class);
        return result;
    }

    @HystrixCommand(
            commandProperties = {
                    // 这里大部分都是默认配置，来查看熔断器的效果
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    // 必须在10秒内发生6个请求，才能使统计数据发挥作用； 默认参数是 20
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "6"),
                    // 在5秒内直接服务降级
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                    // 如果在10秒内超过50%的请求是失败的或潜在的，那么我们将跳闸电路
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
                    // 上面的配置意思就是：在10秒内大于等于6个请求，当有超过3个失败的时候，则在5秒内后面访问该服务则直接服务降级返回
            }
    )
    @GetMapping("/product/list2")
    public String test2(int num) throws InterruptedException {
        // 当传递2的时候直接成功，否则就休眠2秒触发服务降级，模拟服务调用失败效果
        if (num == 2) {
            return "success";
        }
        TimeUnit.SECONDS.sleep(2);
        String result = restTemplate.getForObject("http://127.0.0.1:8080/product/list", String.class);
        return result;
    }

    private String fallback() {
        return "太拥挤了，请稍后再试";
    }

    private String defaultFallback() {
        return "默认提示：太拥挤了，请稍后再试";
    }
}
