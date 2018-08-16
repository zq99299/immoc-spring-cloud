package cn.mrcode.imooc.spring.cloud.product.repository;

import cn.mrcode.imooc.spring.cloud.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ${desc}
 * @author zhuqiang
 * @version 1.0.1 2018/8/16 13:34
 * @date 2018/8/16 13:34
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfroRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfroRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfroRepository.findByProductStatus(0);
        Assert.assertTrue(list.size() > 0);
    }
}