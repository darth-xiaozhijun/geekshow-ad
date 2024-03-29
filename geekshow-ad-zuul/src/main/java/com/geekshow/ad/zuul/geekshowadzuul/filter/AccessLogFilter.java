package com.geekshow.ad.zuul.geekshowadzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * AccessLogFilter for 记录服务请求结束时间，配合{@link PreRequestFilter}计算整个调用请求链路消耗时间
 *
 */
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        //需要最后一个执行的filter
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("Request \"{}\" spent : {} ms.", request.getRequestURI(),
                (System.currentTimeMillis() - Long.valueOf(requestContext.get("api_request_time").toString())));
        return null;
    }
}
