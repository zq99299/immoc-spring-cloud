package cn.mrcode.imooc.spring.cloud.product.service.impl;

import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductCategory;
import cn.mrcode.imooc.spring.cloud.product.repository.ProductCategoryRepository;
import cn.mrcode.imooc.spring.cloud.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
