package com.example.passwordkeychain.model;

public class Account {
    private String siteName;
    private String username;
    private String password;

    public Account(){
        this.siteName = "";
        this.username = "";
        this.password = "";
    }

    public Account(String siteName, String username, String password){
        this.siteName = siteName;
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUsername() {
        return username;
    }

    public String toString(){ return getSiteName();}
}
