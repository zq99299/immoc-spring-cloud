package cn.mrcode.imooc.spring.cloud.product.repository;

import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);
}
