package com.xqq.three.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xuqiangqiang
 * @Date: 2018/7/10 10:19
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface LogRecord {
    String value() default "";

    /**
     * 日志分类，true 操作日志，false 登录日志
     *
     * @return
     */
    boolean type() default true;
}
