package me.cosme.retrofit.githubservice.github.business;

import java.io.IOException;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import me.cosme.retrofit.githubservice.github.repository.IGitHubService;
import me.cosme.retrofit.githubservice.github.repository.Repo;

import static me.cosme.retrofit.githubservice.config.ErrorUtils.parse;

@ApplicationScoped
public class GitHubBusiness {

    private final IGitHubService service;

    public GitHubBusiness() {
        /* default constructor demanded for CDI */
        throw new UnsupportedOperationException();
    }

    @Inject
    public GitHubBusiness(IGitHubService service) {
        this.service = service;
    }

    public List<Repo> list(String user) throws IOException {
        return parse(service.listRepos(user).execute());
    }
}
