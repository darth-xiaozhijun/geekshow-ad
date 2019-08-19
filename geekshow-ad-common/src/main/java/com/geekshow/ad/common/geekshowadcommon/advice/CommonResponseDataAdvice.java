package com.geekshow.ad.common.geekshowadcommon.advice;

import com.geekshow.ad.common.geekshowadcommon.annotation.IgnoreResponseAdvice;
import com.geekshow.ad.common.geekshowadcommon.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * CommonResponseDataAdvice for 统一拦截处理
 * 在响应体返回之前做一些处理；比如，修改返回值、加密等
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否需要对响应进行处理
     * @param methodParameter
     * @param aClass
     * @return false -> 不处理，true -> 处理
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        //获取当前处理请求的controller的方法
        //        String methodName = methodParameter.getMethod().getName().toLowerCase();
        //        // 不拦截/不需要处理返回值 的方法
        //        String method = "login"; //如登录
        //        //不拦截
        //        return !method.equals(methodName);

        // 如果类上标记了@IgnoreResponseAdvice，则不拦截
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        // 如果方法上标记了@IgnoreResponseAdvice，则不拦截
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }

        //对响应进行处理，执行beforeBodyWrite方法
        return true;
    }

    /**
     * 目的 拦截CommonResponse
     * @param body
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return body 原始的Controller需要返回的数据
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        CommonResponse<Object> commonResponse = new CommonResponse<>();

        if (null == body) {
            return commonResponse;
        } else if (body instanceof CommonResponse) {
            commonResponse = (CommonResponse<Object>) body;
        } else {
            commonResponse.setData(body);
        }
        return commonResponse;
    }
}
