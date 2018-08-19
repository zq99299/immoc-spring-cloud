package cn.mrcode.imooc.spring.cloud.product.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/19 11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
}
