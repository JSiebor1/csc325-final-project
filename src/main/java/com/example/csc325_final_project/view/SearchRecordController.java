package com.example.csc325_final_project.view;

import com.example.csc325_final_project.model.RecordData;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

// can search records by table columns
// TODO: need to finish this! and settings page!

public class SearchRecordController {

    @FXML private ChoiceBox<String> choiceBox;
    @FXML private TextField searchRecordField;
    @FXML private Button searchSubmit;

    @FXML private TableView<RecordData> tableView2;
    @FXML private TableColumn<RecordData, String> fNameCol;
    @FXML private TableColumn<RecordData, String> lNameCol;
    @FXML private TableColumn<RecordData, String> clubCol;
    @FXML private TableColumn<RecordData, String> positionCol;
    @FXML private TableColumn<RecordData, String> phoneNumCol;
    @FXML private TableColumn<RecordData, String> emailCol;
    @FXML private TableColumn<RecordData, String> otherCol;

    private final ObservableList<RecordData> recordData = FXCollections.observableArrayList();

    private final Map<String, String> categoryMap = Map.of(
            "First Name", "firstName",
            "Last Name", "lastName",
            "Club", "club",
            "Position", "position",
            "Phone Number", "phoneNum",
            "Email", "email"
    );


    @FXML
    public void initialize() {
        choiceBox.getItems().addAll("First Name", "Last Name", "Club", "Position", "Phone Number", "Email");
        choiceBox.setValue("First Name");

        fNameCol.setCellValueFactory(new PropertyValueFactory<>("fName"));
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lName"));
        clubCol.setCellValueFactory(new PropertyValueFactory<>("club"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        phoneNumCol.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        otherCol.setCellValueFactory(new PropertyValueFactory<>("other"));

        tableView2.setItems(recordData);
    }

    @FXML
    private void searchSubmit(ActionEvent actionEvent) {
        String category = choiceBox.getValue();
        String field = categoryMap.get(category);
        String searchWord = searchRecordField.getText();

        recordData.clear();

        ApiFuture<QuerySnapshot> query = App.fstore.collection("records")
                .whereEqualTo(field, searchWord)
                .get();

        new Thread(() -> {
            try {
                QuerySnapshot querySnapshot = query.get();

                for (QueryDocumentSnapshot recDoc : querySnapshot.getDocuments()) {
                    String fName = recDoc.getString("firstName");
                    String lName = recDoc.getString("lastName");
                    String club = recDoc.getString("club");
                    String position = recDoc.getString("position");
                    String phoneNum = recDoc.getString("phoneNum");
                    String email = recDoc.getString("email");
                    String other = recDoc.getString("other");

                    RecordData record = new RecordData(fName, lName, club, position, phoneNum, email, other);

                    Platform.runLater(() -> recordData.add(record));
                }

                Platform.runLater(() -> tableView2.setItems(recordData));

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

    public void themeHandler(ActionEvent actionEvent) {
        App.changeStyle();
    }

    public void logoutHandler(ActionEvent actionEvent) throws IOException {
        App.setRoot("/files/Login.fxml");
    }
}
