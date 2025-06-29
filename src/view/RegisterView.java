<?xml version="1.0" encoding="UTF-8"?>

        <?import javafx.scene.control.*?>
        <?import javafx.scene.layout.*?>

<AnchorPane xmlns:fx="http://javafx.com/fxml"
        fx:controller="controller.AuthController"
        prefWidth="400" prefHeight="350">

<VBox spacing="10" alignment="CENTER" AnchorPane.topAnchor="40" AnchorPane.leftAnchor="50" AnchorPane.rightAnchor="50">
<Label text="Register New User" style="-fx-font-size: 18;" />
<TextField fx:id="usernameField" promptText="Username" />
<PasswordField fx:id="passwordField" promptText="Password" />
<Label fx:id="errorLabel" textFill="red" />
<HBox spacing="10">
<Button text="Submit" onAction="#handleRegister" />
<Button text="Back to Login" onAction="#handleLogin" />
</HBox>
</VBox>
</AnchorPane>
