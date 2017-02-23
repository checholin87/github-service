package me.cosme.retrofit.githubservice.github.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import me.cosme.retrofit.githubservice.config.HistrixProxy;
import retrofit2.Retrofit;

public class IGitHubServiceFactory {

    @Produces
    @HistrixProxy
    @ApplicationScoped
    public IGitHubService create(Retrofit retrofit) {
        return retrofit.create(IGitHubService.class);
    }
}
