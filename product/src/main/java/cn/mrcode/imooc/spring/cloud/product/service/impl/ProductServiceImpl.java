package cn.mrcode.imooc.spring.cloud.product.service.impl;

import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductInfo;
import cn.mrcode.imooc.spring.cloud.product.enums.ProductStatusEnum;
import cn.mrcode.imooc.spring.cloud.product.repository.ProductInfoRepository;
import cn.mrcode.imooc.spring.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
