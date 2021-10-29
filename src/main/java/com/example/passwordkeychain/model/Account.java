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

    /**
     * Returns the unique ObjectId associated with the account
     * @return ObjectId of the account
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Sets ObjectId for the account
     * @param id - ObjectId to associate with the account
     */
    public void setId(final ObjectId id) {
        this.id = id;
    }

    /**
     * Sets password associated with the account
     * @param password -password associated with the account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets siteName associated with the account
     * @param siteName -site name associated with the account
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * Sets username associated with the account
     * @param username - username associated with the account
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns password associated with the account
     * @return password associated with the account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns site name associated with the account
     * @return site name assocaiated with the account
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * Return username associated with the account
     * @return username associated with the account
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns a String representation of the account
     * @return a String representation of the account
     */
    public String toString(){ return getSiteName();}
}
