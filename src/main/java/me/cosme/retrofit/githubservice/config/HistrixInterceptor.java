package me.cosme.retrofit.githubservice.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@HistrixProxy
public class HistrixInterceptor {

    @AroundInvoke
    public Object circuitBreaker(InvocationContext ctx) throws Exception {

        Object produced = ctx.proceed();
        Class<?>[] interfaces = produced.getClass().getInterfaces();
        Class<?> type = ctx.getMethod().getReturnType();

        return Proxy.newProxyInstance(type.getClassLoader(), interfaces,
            new HistrixInvocationHandler(produced));
    }

    static class HistrixInvocationHandler implements InvocationHandler {

        private Object delegate;

        public HistrixInvocationHandler(Object delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return new HistrixCommand(delegate, method, args).execute();
        }

    }
}
