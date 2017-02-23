package me.cosme.retrofit.githubservice.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import java.lang.reflect.Method;

public class HistrixCommand extends HystrixCommand<Object> {

    final Object proxy;
    final Method method;
    final Object[] args;

    public HistrixCommand(Object proxy, Method method, Object[] args) {
        // TODO set a group based on proxy interfaces
        super(Setter.withGroupKey(
            HystrixCommandGroupKey.Factory.asKey(
                String.format("%s#%s",
                    "proxy-command",
                    "proxy-method")))
            .andCommandKey(
                HystrixCommandKey.Factory.asKey("proxy-command-key")));
        this.proxy = proxy;
        this.method = method;
        this.args = args;
    }

    @Override
    protected Object run() throws Exception {
        return method.invoke(proxy, args);
    }

    @Override
    protected Object getFallback() {
        throw new RuntimeException(String.format("service %s is unavailable",
            this.getCommandGroup().name()));
    }
}
