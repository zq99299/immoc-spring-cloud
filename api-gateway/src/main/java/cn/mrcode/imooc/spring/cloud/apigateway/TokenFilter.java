package cn.mrcode.imooc.spring.cloud.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限拦截认证：简单判定下是否带有 token参数
 * 可以参考 {@link PreDecorationFilter}
 * @author : zhuqiang
 * @version : V1.0
 * @date : 2018/8/19 17:25
 */
@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        // 返回true，则意味着调用 run方法
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // 可以从cookie，header里获取
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            // 不通过
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
            }
        }
        return null;
    }
}
