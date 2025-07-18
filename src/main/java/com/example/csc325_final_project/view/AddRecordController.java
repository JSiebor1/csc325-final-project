package com.example.csc325_final_project.view;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.example.csc325_final_project.view.App.fstore;

// This is to add records to our database collections

public class AddRecordController {

    @FXML private TextField emailField;

    @FXML private TextField fNameField;

    @FXML private TextField lNameField;

    @FXML private TextField otherField;

    @FXML private TextField phoneNumField;

    @FXML private TextField positionField;

    @FXML
    void addRecordButton(ActionEvent event) throws ExecutionException, InterruptedException {
        String fName = fNameField.getText();
        String lName = lNameField.getText();
        String position = positionField.getText();
        String phoneNum = phoneNumField.getText();
        String email = emailField.getText();
        String other = otherField.getText();

        // adding to firebase..
        ApiFuture<QuerySnapshot> query = fstore.collection("records").get();
        QuerySnapshot querySnapshot = query.get();

        Map<String, Object> record = new HashMap<>();
        record.put("firstName", fName);
        record.put("lastName", lName);
        record.put("position", position);
        record.put("phoneNum", phoneNum);
        record.put("email", email);
        record.put("other", other);

        CollectionReference myAppRecords = fstore.collection("records");
        ApiFuture<DocumentReference> result = myAppRecords.add(record);

        fNameField.clear();
        lNameField.clear();
        positionField.clear();
        phoneNumField.clear();
        emailField.clear();
        otherField.clear();

    }

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

    public void themeHandler(ActionEvent actionEvent) {
        App.changeStyle();
    }

    public void logoutHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Login.fxml");
    }
}
