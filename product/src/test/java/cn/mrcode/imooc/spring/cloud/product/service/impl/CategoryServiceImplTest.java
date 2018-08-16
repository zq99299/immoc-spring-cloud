package cn.mrcode.imooc.spring.cloud.product.service.impl;

import cn.mrcode.imooc.spring.cloud.product.ProductApplicationTests;
import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductCategory;
import cn.mrcode.imooc.spring.cloud.product.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * ${desc}
 * @author zhuqiang
 * @version 1.0.1 2018/8/16 14:00
 * @date 2018/8/16 14:00
 * @since 1.0
 */
public class CategoryServiceImplTest extends ProductApplicationTests {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(list.size() > 0);
    }
}