package com.kin.springcloud.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
    // create logger
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // the timing of filtering
    @Override
    public String filterType() {
        return "pre";
    }
    // priority between multiple filters
    @Override
    public int filterOrder() {
        return 1;
    }
    //filter every request
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("Request:{}, Request URI:{}",request,request.getRequestURI());
        return null;
    }
}
