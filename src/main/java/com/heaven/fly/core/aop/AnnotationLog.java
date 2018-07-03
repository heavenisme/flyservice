package com.heaven.fly.core.aop;

import java.lang.annotation.*;

/**
 * @Auther: heaven
 * @Date: 2018/7/3 16:58
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationLog {
    String remark() default "";
}
