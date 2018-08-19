package cn.mrcode.imooc.spring.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
//@EnableCircuitBreaker  // 断路器
@SpringCloudApplication // 自带 @SpringBootApplication  @EnableDiscoveryClient @EnableCircuitBreaker
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
