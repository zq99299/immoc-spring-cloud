package cn.mrcode.imooc.spring.cloud.order.repository;

import cn.mrcode.imooc.spring.cloud.order.OrderApplicationTests;
import cn.mrcode.imooc.spring.cloud.order.dataobject.OrderMaster;
import cn.mrcode.imooc.spring.cloud.order.enums.OrderStatusEnum;
import cn.mrcode.imooc.spring.cloud.order.enums.PayStatusEnum;
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
public class OrderMasterRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("mrcode");
        orderMaster.setBuyerOpenid("123456");
        orderMaster.setBuyerPhone("18512345678");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setOrderAmount(new BigDecimal(0.23));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }
}