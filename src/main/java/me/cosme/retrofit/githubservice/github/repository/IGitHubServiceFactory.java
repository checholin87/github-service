package me.cosme.retrofit.githubservice.github.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import retrofit2.Retrofit;

@ApplicationScoped
public class IGitHubServiceFactory {

    @Produces
    public IGitHubService create(Retrofit retrofit) {
        return retrofit.create(IGitHubService.class);
    }
}
