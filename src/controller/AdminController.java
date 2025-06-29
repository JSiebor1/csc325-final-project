package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button addClubButton;

    @FXML
    private Button viewUsersButton;

    @FXML
    private Button logoutButton;

    @FXML
    void handleAddClub(ActionEvent event) {
        System.out.println("Add Club clicked!");
    }

    @FXML
    void handleViewUsers(ActionEvent event) {
        System.out.println("View Users clicked!");
    }

    @FXML
    void handleLogout(ActionEvent event) {
        System.out.println("Logout clicked!");
    }
}
