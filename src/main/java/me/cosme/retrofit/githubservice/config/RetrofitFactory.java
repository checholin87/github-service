package me.cosme.retrofit.githubservice.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@ApplicationScoped
public class RetrofitFactory {

    @Produces
    public Retrofit create() {
        return new Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();
    }
}
