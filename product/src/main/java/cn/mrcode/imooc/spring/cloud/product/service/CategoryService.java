package cn.mrcode.imooc.spring.cloud.product.service;

import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    /**
     * 按分类类型查询类目
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
