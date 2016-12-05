package me.cosme.retrofit.githubservice.config;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@InterceptorBinding
@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface Histrix {
}
