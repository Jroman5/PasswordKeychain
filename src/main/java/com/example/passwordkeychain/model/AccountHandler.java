package com.example.passwordkeychain.model;

import com.example.passwordkeychain.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/* TODO: 10/28/2021
*   finish integrating the Account handler with the database
*/
public class AccountHandler {
    private ObservableList<Account> accountObservableList;
    private Database db;

    public AccountHandler(){
         this.accountObservableList = FXCollections.observableArrayList();
         init();
    }

    /**
     * updates the Account stored
     * @param index position of account in accountObservableList
     * @param siteName new value for siteName
     * @param username new value for userName
     * @param password new value for password
     */
    public void setAccount(int index, String siteName, String username, String password){
        Account editable = this.accountObservableList.get(index);
        editable.setSiteName(siteName);
        editable.setUsername(username);
        editable.setPassword(password);
        this.accountObservableList.set(index, editable);
        this.db.updateAccount(editable);
    }

    /**
     * removes account stored
     * @param index position of account in accountObservableList
     */
    public void removeAccount(int index){
        this.db.deleteAccount(accountObservableList.get(index));
        this.accountObservableList.remove(index);
    }

    /**
     * Appends a new account to accountObservableList
     * @param siteName site name of new account
     * @param userName username of new account
     * @param password password of new account
     */
    public void addAccount(String siteName, String userName, String password){
        this.accountObservableList.add(new Account(siteName, userName, password));
        this.db.insertAccount(accountObservableList.get(accountObservableList.size()-1));
    }

    /**
     * create link to database and load in all accounts
     */
    private void init(){
        db = db.getInstance();
        getAccountsFromDatabase();

    }

    /**
     * Returns ObservableList containing all Accounts
     * @return ObservableList containing all Accounts
     */
    public ObservableList<Account> getAccountObservableList() {
        return accountObservableList;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if accountObervalbleList is empty.
     */
    public boolean isEmpty(){
        return this.getAccountObservableList().isEmpty();
    }

    /**
     * Loads all Accounts from the database and populates accountObservableList
     */
    private void getAccountsFromDatabase(){
        for(Account acc: db.getAllAccounts()){
            this.accountObservableList.add(acc);
        }
    }
}
