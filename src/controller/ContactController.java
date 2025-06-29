package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Contact;

public class ContactController {

    @FXML
    private TableView<Contact> contactTable;

    @FXML
    private TableColumn<Contact, String> nameColumn;

    @FXML
    private TableColumn<Contact, String> phoneColumn;

    @FXML
    private TableColumn<Contact, String> emailColumn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private Button addButton;

    private ObservableList<Contact> contactList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        contactTable.setItems(contactList);
    }

    @FXML
    void handleAddContact() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();

        if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
            Contact newContact = new Contact(name, phone, email);
            contactList.add(newContact);
            nameField.clear();
            phoneField.clear();
            emailField.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all contact fields.");
            alert.show();
        }
    }
}
