package com.example.csc325_final_project.view;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SearchRecordController {

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
        App.setRoot("/files/SearchRecord.fxml");
    }

    public void settingsHandler(ActionEvent actionEvent) {
    }

    public void logoutHandler(ActionEvent actionEvent) {
    }
}
