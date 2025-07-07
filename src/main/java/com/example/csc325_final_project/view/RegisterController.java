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

    public void loginHandler(ActionEvent actionEvent) throws IOException {
        boolean registered = AccessFBView.registerUser(EmailTF.getText(), PasswordTF.getText(), PhoneTF.getText(), NameTF.getText());
        if(registered) {
            App.setRoot("/files/Login.fxml");
        }
    }

    public void uploadHandler(ActionEvent actionEvent) {
    }

    public void mainMenuHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/AccessFBView.fxml");
    }
}
