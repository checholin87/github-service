package me.cosme.retrofit.githubservice.github.service;

import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import me.cosme.retrofit.githubservice.github.business.GitHubBusiness;

@Path("/github")
public class GitHubService {

    @Inject
    private GitHubBusiness business;

    public GitHubService() {
        /* required no param constructor */;
    }

    @GET
    @Path("/{user}")
    @Produces("application/json")
    public RepoListResponse list(@PathParam("user") String user) throws IOException {
        return new RepoListResponse(business.list(user));
    }
}
