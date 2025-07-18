package com.example.csc325_final_project.view;


import com.example.csc325_final_project.model.FirestoreContext;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Firestore fstore;
    public static FirebaseAuth fauth;
    public static Scene scene;
    private final FirestoreContext contxtFirebase = new FirestoreContext();
    static int style = 1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fstore = contxtFirebase.firebase();
        fauth = FirebaseAuth.getInstance();
        scene = new Scene(loadFXML("/files/Login.fxml"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml ));
        return fxmlLoader.load();
    }

    public static void changeStyle() {
        if(style == 0) {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(App.class.getResource("/files/default.css").toExternalForm());
            style++;
        }
        else if(style == 1) {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(App.class.getResource("/files/dark.css").toExternalForm());
            style--;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
