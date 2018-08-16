package cn.mrcode.imooc.spring.cloud.order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/16 23:09
 */
@FeignClient(name = "product")   // 服务名
public interface FeignClientServer {
    @GetMapping("/test/hello")
        // 定义需要调用的接口
    String hello();
}
