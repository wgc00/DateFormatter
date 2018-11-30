package com.wgc.jsonp.annotations;

import java.lang.annotation.*;

/*
* @Documented
* @Retention
* @Target
* 这个头部如果不会写，可以IDEA中查找@DateTimeFormat注解，
* 直接复制@DateTimeFormat头部就可以了
* */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface DateFormID {

}