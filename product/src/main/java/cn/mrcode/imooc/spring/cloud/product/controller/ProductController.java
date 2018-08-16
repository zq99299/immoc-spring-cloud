package cn.mrcode.imooc.spring.cloud.product.controller;

import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductCategory;
import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductInfo;
import cn.mrcode.imooc.spring.cloud.product.service.CategoryService;
import cn.mrcode.imooc.spring.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    /**
     * 1. 查询所有在架的商品
     * 2. 查询类目
     * 3. 构造数据，程序中进行数据的组装
     */
    @GetMapping("/list")
    public void list() {
        // 获取商品
        List<ProductInfo> productInfos = productService.findUpAll();
        // 获取商品中包含的类目
        List<Integer> categoryList = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        // 查询出所有的类目
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(categoryList);

    }
}
