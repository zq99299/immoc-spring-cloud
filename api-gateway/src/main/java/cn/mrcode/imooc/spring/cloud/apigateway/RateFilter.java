package cn.mrcode.imooc.spring.cloud.apigateway;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 令牌桶限流过滤器
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/19 17:53
 */
@Component
public class RateFilter extends ZuulFilter {
    // 每秒放入两个令牌
    private RateLimiter rateLimiter = RateLimiter.create(100);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 尝试获取令牌
        if (rateLimiter.tryAcquire()) {
            throw new RuntimeException("限流异常");
        }
        return null;
    }
}
