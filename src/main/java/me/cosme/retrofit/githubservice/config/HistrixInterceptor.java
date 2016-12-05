package me.cosme.retrofit.githubservice.config;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Histrix // binding the interceptor here. now any method annotated with @Histrix would be intercepted by logMethodEntry
public class HistrixInterceptor {
    @AroundInvoke
    public Object circuitBreaker(InvocationContext ctx) throws Exception {
        // logger
        System.out.println("Entering method: " + ctx.getMethod().getName());

        // histrix
        return new HistrixCommand(ctx).execute();
    }
}
