package com.example.passwordkeychain.control;

import com.example.passwordkeychain.model.Account;
import com.example.passwordkeychain.model.AccountHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/*TODO: 10/25/2021
    update the delete and save such that NullPointerExceptions dont occur(deleting on an empty list, saving on an empty list)
    look into making a method that creates an account object and adds it to the list in AccountHandler
   create database handler (should be able to return an ObservableList<Account> for the list view to use)
   create database
   create init protocols
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
    private ListView<Account> websites = new ListView<>(accountHandler.getAccountObservableList());



    @FXML
    protected void onItemSelect(){
        Account selected = websites.getSelectionModel().getSelectedItem();
        site_name_field.setText(selected.getSiteName());
        site_username_field.setText(selected.getUsername());
        site_password_field.setText(selected.getPassword());

    }

    @FXML
    protected void onSaveButtonClick() {
        Account editable = websites.getSelectionModel().getSelectedItem();
        editable.setSiteName(site_name_field.getText());
        editable.setUsername(site_username_field.getText());
        editable.setPassword(site_password_field.getText());

        accountHandler.setAccount(websites.getSelectionModel().getSelectedIndex(), editable);
    }

    @FXML
    protected void onDeleteButtonClick(){
        accountHandler.removeAccount(websites.getSelectionModel().getSelectedIndex());

    }

    @FXML
    protected void onNewSiteButtonClick(){
        websites.setItems(accountHandler.getAccountObservableList());
        accountHandler.addAccount(new Account(site_name_field.getText(), site_username_field.getText(), site_password_field.getText()));

    }
}