package me.cosme.retrofit.githubservice.config;

import com.google.gson.Gson;
import retrofit2.Response;

public class ErrorUtils {

    private static final Gson GSON = new Gson();

    public static <T> T parse(Response<T> response) {
        if (response.isSuccessful()) {
            return response.body();
        } else {
            GitHubErrorMessage message = null;
            try {
                message = GSON.fromJson( response.errorBody().string(), 
                    GitHubErrorMessage.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            throw new GitHubServiceException(message);

        }
    }
}
