package cn.mrcode.imooc.spring.cloud.order.client;

import cn.mrcode.imooc.spring.cloud.order.dataobject.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/16 23:46
 */
@FeignClient(name = "product")
public interface ProductClient {
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(List<String> productIdList);

    @GetMapping("/product/list")
    String list();


}
