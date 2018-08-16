package cn.mrcode.imooc.spring.cloud.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/16 22:15
 */
@RestController
@RequestMapping("/test")
public class DemoServerController {
    @GetMapping("/hello")
    public String hello() {
        return "这是商品服务测试-hellop";
    }
}
