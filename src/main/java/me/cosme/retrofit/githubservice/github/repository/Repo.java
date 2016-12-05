package me.cosme.retrofit.githubservice.github.repository;

import java.io.Serializable;

public class Repo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String full_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "Repo [id=" + id + ", name=" + name + ", full_name=" + full_name
                + "]";
    }

}
