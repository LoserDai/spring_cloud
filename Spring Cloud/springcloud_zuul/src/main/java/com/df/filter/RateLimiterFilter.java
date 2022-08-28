package com.df.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author Loser
 * @date 2021年11月16日 10:57
 */
@Component
public class RateLimiterFilter extends ZuulFilter {
    //桶：每秒往桶里放一个令牌
    private RateLimiter rateLimiter = RateLimiter.create(1);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
    //如果访问速度过快,会限流
    @Override
    public Object run() throws ZuulException {
        if (!rateLimiter.tryAcquire()){
            RequestContext rc = RequestContext.getCurrentContext();
            rc.setSendZuulResponse(false);// 代表请求结束。不在继续向下请求
            rc.setResponseStatusCode(401);// 添加一个响应的状态码
            rc.setResponseBody("限流了，稍后再访问！！！");// 响应内容
            rc.getResponse().setContentType("text/html;charset=utf-8");// 响应类型
        }
        return null;
    }
}
