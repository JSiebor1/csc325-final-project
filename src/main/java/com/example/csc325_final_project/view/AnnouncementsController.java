package com.example.csc325_final_project.view;

import com.example.csc325_final_project.model.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

// getting user name and showing the announcements
//TODO: the announcements inputs

public class AnnouncementsController {
    public TextArea announcementsTA;

    @FXML private Label welcomeLabel;

    @FXML
    public void initialize() {
        String username = Session.getUsername();
        welcomeLabel.setText("Welcome " + username + "!");
    }

    @FXML
    public void announcementsHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Announcements.fxml");
    }
    @FXML
    public void recordListHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/RecordList.fxml");
    }

    @FXML
    public void addRecordsHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/AddRecord.fxml");
    }

    @FXML
    public void searchRecordsHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/SearchRecord.fxml");
    }

    @FXML
    public void themeHandler(ActionEvent actionEvent) {
    }

    @FXML
    public void logoutHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Login.fxml");
    }
}