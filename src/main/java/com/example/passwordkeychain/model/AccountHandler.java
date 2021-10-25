package com.example.passwordkeychain.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccountHandler {
    private ObservableList<Account> accountObservableList;

    public AccountHandler(){
         this.accountObservableList = FXCollections.observableArrayList();
    }

    public void setAccount(int index, String siteName, String username, String password){
        Account editable = this.accountObservableList.get(index);
        editable.setSiteName(siteName);
        editable.setUsername(username);
        editable.setPassword(password);
        this.accountObservableList.set(index, editable);
    }

    public void removeAccount(Account account){
        this.accountObservableList.remove(account);
    }

    public void removeAccount(int index){
        this.accountObservableList.remove(index);
    }

    public void addAccount(Account account){
        this.accountObservableList.add(account);
    }

    public void addAccount(String siteName, String userName, String password){
        this.accountObservableList.add(new Account(siteName, userName, password));
    }

    //create link to database and load in all accounts
    private void init(){

    }

    public ObservableList<Account> getAccountObservableList() {
        return accountObservableList;
    }

    public boolean isEmpty(){
        return this.getAccountObservableList().isEmpty();
    }
}
