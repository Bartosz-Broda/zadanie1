package com.example.zadanie1.model;

public class RepoDetailsModel {

    private String name;
    private String description;
    private String language;
    private String created_at;
    private String updated_at;
    private int watchers;
    private int size;

    public RepoDetailsModel(String name, String description, String language, String created_at, String updated_at, int watchers, int size) {
        this.name = name;
        this.description = description;
        this.language = language;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.watchers = watchers;
        this.size = size;
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

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
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
}
