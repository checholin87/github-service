package me.cosme.retrofit.githubservice.config;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GitHubServiceExceptionHandler implements ExceptionMapper<GitHubServiceException> {

    public GitHubServiceExceptionHandler() {
        /* required no arguments constructor */
    }

    @Override
    public Response toResponse(GitHubServiceException exception) {
        return Response.status(Status.BAD_REQUEST)
            .entity(exception.getGitHubMessage())
            .type(MediaType.APPLICATION_JSON).build();
    }

}
