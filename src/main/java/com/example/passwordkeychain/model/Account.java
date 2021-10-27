package com.example.passwordkeychain.model;

import org.bson.types.ObjectId;

public class Account {
    private ObjectId id;
    private String siteName;
    private String username;
    private String password;

    public Account(){
        this.setId(new ObjectId());
    }

    public Account(String siteName, String username, String password){
        this.setId(new ObjectId());
        this.siteName = siteName;
        this.username = username;
        this.password = password;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
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
