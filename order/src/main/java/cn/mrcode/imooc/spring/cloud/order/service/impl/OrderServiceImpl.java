package cn.mrcode.imooc.spring.cloud.order.service.impl;

import cn.mrcode.imooc.spring.cloud.order.client.ProductClient;
import cn.mrcode.imooc.spring.cloud.order.dataobject.OrderDetail;
import cn.mrcode.imooc.spring.cloud.order.dataobject.OrderMaster;
import cn.mrcode.imooc.spring.cloud.order.dataobject.ProductInfo;
import cn.mrcode.imooc.spring.cloud.order.dto.OrderDTO;
import cn.mrcode.imooc.spring.cloud.order.enums.OrderStatusEnum;
import cn.mrcode.imooc.spring.cloud.order.enums.PayStatusEnum;
import cn.mrcode.imooc.spring.cloud.order.repository.OrderDetailRepository;
import cn.mrcode.imooc.spring.cloud.order.repository.OrderMasterRepository;
import cn.mrcode.imooc.spring.cloud.order.service.OrderService;
import cn.mrcode.imooc.spring.cloud.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 廖师兄
 * 2017-12-10 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        // 目前商品信息还在之前另外一个服务上，所以这里的步骤没法实现
        // TODO: 2018/8/16 查询商品信息（调用商品服务）
        List<String> pids = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfos = productClient.listForOrder(pids);
        // 为了掩饰服务追踪，在该方法中特意再调用了其他的服务
        String list = productClient.list();
        // TODO: 2018/8/16  计算总价
        // TODO: 2018/8/16  扣库存（调用商品服务）

        String orderId = KeyUtil.genUniqueKey();
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

}
