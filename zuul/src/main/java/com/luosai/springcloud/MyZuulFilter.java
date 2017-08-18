package com.luosai.springcloud;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * Created by sai.luo on 2017-8-18.
 */
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE; //过滤器类型 有pre route post error
    }

    @Override
    public int filterOrder() {
        return 1;  //过滤器顺序 越小越优先
    }

    @Override
    public boolean shouldFilter() {
        return true; //是否过滤
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletResponse response = currentContext.getResponse();
        Cookie cookie = new Cookie("time-respose", "nowtamstamp" + System.currentTimeMillis());
        response.addCookie(cookie);
        return null;
    }
}
