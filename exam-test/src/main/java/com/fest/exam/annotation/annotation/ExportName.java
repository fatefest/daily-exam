package com.fest.exam.annotation.annotation;


import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExportName {

    String value() default "";

    String name() default "";

}
