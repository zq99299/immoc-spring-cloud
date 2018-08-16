package cn.mrcode.imooc.spring.cloud.product.repository;

import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ${desc}
 * @author zhuqiang
 * @version 1.0.1 2018/8/16 13:31
 * @date 2018/8/16 13:31
 * @since 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
