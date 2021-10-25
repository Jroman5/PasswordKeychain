package com.example.passwordkeychain.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccountHandler {
    private ObservableList<Account> accountObservableList;

    public AccountHandler(){
         this.accountObservableList = FXCollections.observableArrayList();
    }

    public void setAccount(int index, Account account){
        this.accountObservableList.set(index, account);
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

    //create link to database and load in all accounts
    private void init(){

    }

    public ObservableList<Account> getAccountObservableList() {
        return accountObservableList;
    }
}
