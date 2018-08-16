package cn.mrcode.imooc.spring.cloud.product.service;

import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    List<ProductInfo> findByIds(List<String> productIds);
}
