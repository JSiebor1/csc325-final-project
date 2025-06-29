package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Club;

public class ClubController {

    @FXML
    private TableView<Club> clubTable;

    @FXML
    private TableColumn<Club, String> nameColumn;

    @FXML
    private TableColumn<Club, String> descriptionColumn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button addButton;

    private ObservableList<Club> clubList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());

        clubTable.setItems(clubList);
    }

    @FXML
    void handleAddClub() {
        String name = nameField.getText().trim();
        String description = descriptionField.getText().trim();

        if (!name.isEmpty() && !description.isEmpty()) {
            Club newClub = new Club(name, description);
            clubList.add(newClub);
            nameField.clear();
            descriptionField.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Both name and description are required.");
            alert.show();
        }
    }
}
