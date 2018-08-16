package cn.mrcode.imooc.spring.cloud.product.utils;

import cn.mrcode.imooc.spring.cloud.product.VO.ResultVO;

/**
 * ${desc}
 * @author zhuqiang
 * @version 1.0.1 2018/8/16 14:58
 * @date 2018/8/16 14:58
 * @since 1.0
 */
public class ResultVOUtil {
    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
