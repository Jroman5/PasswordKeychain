package com.example.passwordkeychain.control;

import com.example.passwordkeychain.model.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PasswordController {

    @FXML
    private Label site_name_label;

    @FXML
    private Label site_username_label;

    @FXML
    private Label site_password_label;

    @FXML
    private TextField site_name_field;

    @FXML
    private TextField site_username_field;

    @FXML
    private TextField site_password_field;

    @FXML
    private ListView<Account> websites = new ListView<>();

    private ObservableList<Account> ol = FXCollections.observableArrayList();




    @FXML
    protected void onSaveButtonClick() {
        site_name_field.setText("Test button");
    }

    @FXML
    protected void onDeleteButtonClick(){
        site_username_field.setText("Test delete");
    }

    @FXML
    protected void onNewSiteButtonClick(){
        websites.setItems(ol);
        ol.addAll(new Account(site_name_field.getText(), site_username_field.getText(), site_password_field.getText()));
    }
}