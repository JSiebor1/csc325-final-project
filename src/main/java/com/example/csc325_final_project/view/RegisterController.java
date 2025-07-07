package com.example.csc325_final_project.view;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {
    public TextField EmailTF;
    public PasswordField PasswordTF;
    public TextField PhoneTF;
    public TextField NameTF;

    public void registerHandler(ActionEvent actionEvent) throws IOException {
        boolean registered = AccessFBView.registerUser(EmailTF.getText(), PasswordTF.getText(), PhoneTF.getText(), NameTF.getText());
        // TODO if registered, display a label saying the user can now login, if user already exists, display error
    }

    public void loginHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Login.fxml");
    }
}
