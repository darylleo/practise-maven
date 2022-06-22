package com.daryl.mytest.annotationtest;

import java.lang.annotation.*;

/**
 * @author wl
 * @create 2022-02-16
 */
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Daryl {
}
