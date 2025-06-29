<?xml version="1.0" encoding="UTF-8"?>

        <?import javafx.scene.control.*?>
        <?import javafx.scene.layout.*?>

<BorderPane xmlns:fx="http://javafx.com/fxml"
        fx:controller="controller.AdminController"
        prefWidth="600" prefHeight="400">

<top>
<ToolBar>
<Label fx:id="welcomeLabel" text="Welcome, Admin!" />
<Button fx:id="logoutButton" text="Logout" onAction="#handleLogout" />
</ToolBar>
</top>

<center>
<VBox alignment="CENTER" spacing="15">
<Button fx:id="addClubButton" text="Manage Clubs" onAction="#handleAddClub" />
<Button fx:id="viewUsersButton" text="View Users" onAction="#handleViewUsers" />
</VBox>
</center>
</BorderPane>
