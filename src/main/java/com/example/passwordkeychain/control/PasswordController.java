package com.example.passwordkeychain.control;

import com.example.passwordkeychain.model.Account;
import com.example.passwordkeychain.model.AccountHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/*TODO: 10/28/2021
   add encryption
*  */

public class PasswordController {
    private AccountHandler accountHandler = new AccountHandler();

    @FXML
    private TextField site_name_field;

    @FXML
    private TextField site_username_field;

    @FXML
    private TextField site_password_field;

    @FXML
    private ListView<Account> websites = new ListView<Account>(accountHandler.getAccountObservableList()) ;


    /**
     * Links the ListView to the AccountObservableList from the accountHandler
     */
    public void initialize(){
        websites.setItems(accountHandler.getAccountObservableList());
    }

    /**
     * Displays the information associated to the account that was selected
     */
    @FXML
    protected void onItemSelect(){
        if(websites.getSelectionModel().getSelectedItem() == null){
            return;
        }
        Account selected = websites.getSelectionModel().getSelectedItem();
        site_name_field.setText(selected.getSiteName());
        site_username_field.setText(selected.getUsername());
        site_password_field.setText(selected.getPassword());

    }

    /**
     * updates the selected account with the information store retrieved from the text fields
     */
    @FXML
    protected void onSaveButtonClick() {
        if(accountHandler.isEmpty()){
            return;
        }
        accountHandler.setAccount(websites.getSelectionModel().getSelectedIndex()
                ,site_name_field.getText()
                ,site_username_field.getText()
                ,site_password_field.getText());
    }

    /**
     * Deletes the account selected
     */
    @FXML
    protected void onDeleteButtonClick(){
        if(accountHandler.isEmpty()){
            return;
        }

        accountHandler.removeAccount(websites.getSelectionModel().getSelectedIndex());

    }

    /**
     * Appends a new Account to the accountHandler
     */
    @FXML
    protected void onNewSiteButtonClick(){
        accountHandler.addAccount(site_name_field.getText(), site_username_field.getText(), site_password_field.getText());
    }

}