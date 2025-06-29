package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class AuthController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isBlank() || password.isBlank()) {
            errorLabel.setText("Username or password cannot be empty.");
            return;
        }

        if (username.equals("admin") && password.equals("admin123")) {
            loadMainPage();
        } else {
            errorLabel.setText("Invalid credentials.");
        }
    }

    @FXML
    void handleRegister(ActionEvent event) {
        errorLabel.setText("Registration not implemented yet.");
    }

    private void loadMainPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainPageView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Main Page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
