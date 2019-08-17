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

@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否需要对响应进行处理
     *
     * @return false -> 不处理，true -> 处理
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        //
        //        //获取当前处理请求的controller的方法
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
     *
     * @param body 原始的Controller需要返回的数据
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

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
