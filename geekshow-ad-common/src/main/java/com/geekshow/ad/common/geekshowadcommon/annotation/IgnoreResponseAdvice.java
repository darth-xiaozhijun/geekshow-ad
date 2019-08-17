package com.geekshow.ad.common.geekshowadcommon.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * IgnoreResponseAdvice for 标示需要忽略拦截动作
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang</a>
 */
//ElementType.TYPE 表示该注解可用于class
//ElementType.METHOD 表示可用于方法
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
