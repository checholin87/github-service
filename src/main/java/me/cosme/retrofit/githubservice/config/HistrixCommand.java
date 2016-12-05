package me.cosme.retrofit.githubservice.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import javax.interceptor.InvocationContext;

import static com.google.common.base.Preconditions.checkNotNull;

public class HistrixCommand extends HystrixCommand<Object> {

    private final InvocationContext ctx;

    public HistrixCommand(InvocationContext ctx) {
        super(HystrixCommandGroupKey.Factory.asKey(
            String.format("%s#%s",
                ctx.getMethod().getDeclaringClass().getName(),
                ctx.getMethod().getName())));
        checkNotNull(ctx);
        this.ctx = ctx;
    }

    @Override
    protected Object run() throws Exception {
        return ctx.proceed();
    }

    @Override
    protected Object getFallback() {
        throw new RuntimeException(String.format("service %s is unavailable", 
            this.getCommandGroup().name()));
    }
}
