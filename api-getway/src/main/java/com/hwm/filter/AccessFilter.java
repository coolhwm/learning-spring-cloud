package com.hwm.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * AccessFilter
 *
 * @author hwm
 * @since 2017/3/16
 **/
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);


    @Override
    public String filterType() {
        //设置过滤器的类型 pre/routing/post/error
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否启动过滤
        return true;
    }

    @Override
    public Object run() {
        //获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        //获取请求参数
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");

            //设置返回状态
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
