package me.cosme.retrofit.githubservice.github.service;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import me.cosme.retrofit.githubservice.github.repository.Repo;

@XmlRootElement
public class RepoListResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private List<Repo> repositories;

    public RepoListResponse() {
        /* required no param constructor */;
    }

    public RepoListResponse(List<Repo> repositories) {

        this.repositories = repositories;
    }

    @XmlTransient
    public List<Repo> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repo> repositories) {
        this.repositories = repositories;
    }

}
