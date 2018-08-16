package cn.mrcode.imooc.spring.cloud.product.controller;

import cn.mrcode.imooc.spring.cloud.product.utils.ResultVOUtil;
import cn.mrcode.imooc.spring.cloud.product.VO.ProductInfoVO;
import cn.mrcode.imooc.spring.cloud.product.VO.ProductVO;
import cn.mrcode.imooc.spring.cloud.product.VO.ResultVO;
import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductCategory;
import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductInfo;
import cn.mrcode.imooc.spring.cloud.product.service.CategoryService;
import cn.mrcode.imooc.spring.cloud.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public ResultVO list() {
        // 获取商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 获取商品中包含的类目
        List<Integer> categoryList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        // 查询出所有的类目
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(categoryList);

        // 商品按类目分类
        Map<Integer, List<ProductInfo>> productGroups = productInfoList.stream().collect(Collectors.groupingBy(ProductInfo::getCategoryType));

        // 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categories) {
            Integer categoryType = category.getCategoryType();
            List<ProductInfo> productInfos = productGroups.get(categoryType);
            if (productGroups == null) {
                continue;
            }
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(categoryType);
            List<ProductInfoVO> productInfoVOList = productInfos.stream().map(product -> {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                BeanUtils.copyProperties(product, productInfoVO);
                return productInfoVO;
            }).collect(Collectors.toList());
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
