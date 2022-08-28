package com.df.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Loser
 * @date 2021年11月16日 10:46
 */
@Component
public class PreFilter extends ZuulFilter {
    //过滤器类型：pre在路由之前执行
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    //优先级：数值越小优先级越高
    @Override
    public int filterOrder() {
        return 0;
    }
    //过滤器是否执行：true执行
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //判断是否有token参数
    @Override
    public Object run() throws ZuulException {
        //获取环境
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        String token = request.getParameter("token");
        if (token == null){
            System.out.println("token == null...");
            rc.setSendZuulResponse(false); // 代表请求结束,不再继续向下请求
            rc.setResponseStatusCode(404); // 添加响应的状态码
            rc.setResponseBody("请登录后再访问!!!"); //响应内容
            rc.getResponse().setContentType("text/html;charset=utf-8"); //设置格式
        }else {
            System.out.println("token is OK !!!");
        }
        return null;
    }
}
