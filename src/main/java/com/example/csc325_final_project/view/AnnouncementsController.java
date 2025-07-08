package com.example.csc325_final_project.view;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class AnnouncementsController {
    public TextArea announcementsTA;
    public Label welcomeLabel;

    public void announcementsHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Announcements.fxml");
    }
    public void recordListHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/RecordList.fxml");
    }

    public void addRecordsHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/AddRecord.fxml");
    }

    public void searchRecordsHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/AddRecord.fxml");
    }

    public void settingsHandler(ActionEvent actionEvent) {
    }

    public void logoutHandler(ActionEvent actionEvent) throws IOException {
    }
}
