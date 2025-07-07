package com.example.csc325_final_project.view;

import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {

    public void loginHandler(ActionEvent actionEvent) {
        // TODO: verify user credentials then switch to events screen
    }

    public void registerHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Register.fxml");
    }
}
