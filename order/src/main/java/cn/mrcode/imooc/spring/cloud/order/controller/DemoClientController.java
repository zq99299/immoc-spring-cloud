package cn.mrcode.imooc.spring.cloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate 的三种用法
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/16 22:12
 */
@RequestMapping("/test")
//@RestController  // 这里定义的会影响其他地方使用RestTemplate。可以先注释掉
public class DemoClientController {
    @GetMapping("/word1")
    public String word1() {
        // 1. 直接使用restTemplate，url写死
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/test/hello", String.class);
        return result;
    }

    //~~==============================  方法2 ==============
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/word2")
    public String word2() {
        // 2. 使用 LoadBalancerClient 通过应用名获取url，然后再使用restTemplate
        // 可以不用写ip地址了，解决了有多个服务的问题，但是还是有一点麻烦
        ServiceInstance si = loadBalancerClient.choose("product");
        String url = String.format("http://%s:%s", si.getHost(), si.getPort());
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url + "/test/hello", String.class);
        return result;
    }

    //~~==============================  方法3 ==============
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/word3")
    public String word3() {
        // 3. 使用@LoadBalanced注解 + RestTemplate 简化第2种里面的步骤

        // 这里传递的是服务名，不需要使用ip和端口号了
        String result = restTemplate.getForObject("http://product/test/hello", String.class);
        return result;
    }

    @Autowired
    private FeignClientServer feignClientServer;

    @GetMapping("/word4")
    public String word4() {
        return feignClientServer.hello();
    }
}
