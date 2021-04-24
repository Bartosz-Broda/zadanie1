package com.example.zadanie1.model;

public class RepoDetailsModel {

    private String name;
    private String description;
    private String language;
    private String created_at;
    private String pushed_at;
    private String default_branch;
    private Owner owner;
    private int watchers;
    private int size;
    private int forks;

    public RepoDetailsModel(String name, String description, String language, String created_at, String pushed_at, String default_branch, Owner owner, int watchers, int size, int forks) {
        this.name = name;
        this.description = description;
        this.language = language;
        this.created_at = created_at;
        this.pushed_at = pushed_at;
        this.default_branch = default_branch;
        this.owner = owner;
        this.watchers = watchers;
        this.size = size;
        this.forks = forks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getForks() {
        return forks;
    }

    public String getDefault_branch() {
        return default_branch;
    }
}
