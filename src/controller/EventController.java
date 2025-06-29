package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Event;

public class EventController {

    @FXML
    private TableView<Event> eventTable;

    @FXML
    private TableColumn<Event, String> nameColumn;

    @FXML
    private TableColumn<Event, String> dateColumn;

    @FXML
    private TableColumn<Event, String> locationColumn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField locationField;

    @FXML
    private Button addButton;

    private final ObservableList<Event> eventList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        locationColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());

        eventTable.setItems(eventList);
    }

    @FXML
    void handleAddEvent() {
        String name = nameField.getText().trim();
        String date = dateField.getText().trim();
        String location = locationField.getText().trim();

        if (!name.isEmpty() && !date.isEmpty() && !location.isEmpty()) {
