package com.lvt.waifuranker.models;

public class User {

    private String username;
    private String password;
    private Long waifulistId;

    public User(String username, String password, Long waifulist) {
        this.username = username;
        this.password = password;
        this.waifulistId = waifulist;
    }

    public User (String username, String password) {
        this.username = username;
        this.password = password;
        this.waifulistId = 0L;
    }

    public User () {
        this.username = "";
        this.password = "";
        this.waifulistId = 0L;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getWaifuList() {
        return waifulistId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWaifuList(Long waifulist) {
        this.waifulistId = waifulist;
    }

}
