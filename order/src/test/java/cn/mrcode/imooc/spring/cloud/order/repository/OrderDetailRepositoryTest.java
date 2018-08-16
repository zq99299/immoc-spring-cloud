package cn.mrcode.imooc.spring.cloud.order.repository;

import cn.mrcode.imooc.spring.cloud.order.OrderApplicationTests;
import cn.mrcode.imooc.spring.cloud.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * ${desc}
 * @author zhuqiang
 * @version 1.0.1 2018/8/16 15:23
 * @date 2018/8/16 15:23
 * @since 1.0
 */
public class OrderDetailRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12367");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("123456");
        orderDetail.setProductIcon("http://xxx");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }

    @Test
    public void findByOrderId() {
    }
}