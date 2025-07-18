package com.example.csc325_final_project.view;

import com.example.csc325_final_project.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.io.IOException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

// shows record list on a table / displays collection fields from firebase

public class RecordListController implements Initializable {

    @FXML private TableView<RecordData> tableView;
    @FXML private TableColumn<RecordData, String> fNameCol;
    @FXML private TableColumn<RecordData, String> lNameCol;
    @FXML private TableColumn<RecordData, String> positionCol;
    @FXML private TableColumn<RecordData, String> phoneNumCol;
    @FXML private TableColumn<RecordData, String> emailCol;
    @FXML private TableColumn<RecordData, String> otherCol;

    private final ObservableList<RecordData> recordData = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("fName"));
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lName"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        phoneNumCol.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        otherCol.setCellValueFactory(new PropertyValueFactory<>("other"));
        displayRecords();
    }

    private void displayRecords() {
        ApiFuture<QuerySnapshot> query = App.fstore.collection("records").get();
        new Thread(() -> {
            try {
                QuerySnapshot querySnapshot = query.get();
                for (QueryDocumentSnapshot recDoc : querySnapshot.getDocuments()) {
                    String fName = recDoc.getString("firstName");
                    String lName = recDoc.getString("lastName");
                    String position = recDoc.getString("position");
                    String phoneNum = recDoc.getString("phoneNum");
                    String email = recDoc.getString("email");
                    String other = recDoc.getString("other");

                    RecordData record = new RecordData(fName, lName, position, phoneNum, email, other);
                    Platform.runLater(() -> recordData.add(record));
                }

                Platform.runLater(() -> tableView.setItems(recordData));

            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
                Platform.runLater(() -> System.out.println("Failed to retrieve."));
            }
        }).start();
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

    public void settingsHandler(ActionEvent actionEvent) throws IOException {

    }

    public void logoutHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Login.fxml");
    }

}
