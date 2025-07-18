package com.example.csc325_final_project.view;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

// registers users to firebase so they can log in

public class RegisterController {

    @FXML private TextField emailField;

    @FXML private PasswordField confirmPasswordField;

    @FXML private PasswordField passwordField;

    @FXML private Label errorLabel;

    public void registerHandler(ActionEvent actionEvent) {
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Passwords do not match.");
            return;
        }

        try {
            registerUser(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("An error occurred during registration.");
        }

    }

    public void loginHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Login.fxml");
    }

    public static String getApiKey() {
        Properties prop = new Properties();
        try {
            FileInputStream fileInput = new FileInputStream("config.properties");
            prop.load(fileInput);
            return prop.getProperty("apiKey");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String apiKey = getApiKey();

    private void registerUser(String email, String password) {
        try {
            URL url = new URL("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + apiKey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = String.format(
                    "{\"email\":\"%s\",\"password\":\"%s\",\"returnSecureToken\":true}",
                    email, password
            );

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();

            Scanner scanner;
            if (code == 200) {
                scanner = new Scanner(conn.getInputStream(), "utf-8");
                errorLabel.setText("Registered successfully. Now Login!");
            } else {
                scanner = new Scanner(conn.getErrorStream(), "utf-8");
                errorLabel.setText("Registration failed. Try again.");
            }

            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            System.out.println("Response: " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("An error occurred during registration.");
        }
    }
}


