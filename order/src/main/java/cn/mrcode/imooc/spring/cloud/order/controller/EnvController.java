package cn.mrcode.imooc.spring.cloud.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/18 11:14
 */
@RestController
@RefreshScope
public class EnvController {
    @Value("${env}")
    private String env;

    @GetMapping("/env/print")
    public String env() {
        return env;
    }
}
