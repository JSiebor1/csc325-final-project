package com.example.csc325_final_project.view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddRecordController {
    public TextField LnameTF;
    public TextField PhoneTF;
    public TextField FnameTF;
    public TextField OtherTF;
    public TextField PositionTF;
    public TextField EmailTF;

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

    public void addRecordButtonHandler(ActionEvent actionEvent) {
        // add info from textfields into document

    }
}
