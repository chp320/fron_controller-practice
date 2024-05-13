package org.example.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})         // annotation 을 class 에 사용하기 위함
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
