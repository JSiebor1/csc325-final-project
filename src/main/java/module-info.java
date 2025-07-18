module com.example.csc325_final_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires jdk.jsobject;
    requires java.xml;
    requires java.logging;
    requires javafx.web;
    requires com.google.auth.oauth2;
    requires google.cloud.firestore;
    requires firebase.admin;
    requires com.google.api.apicommon;

    requires google.cloud.core;
    requires com.google.auth;
    requires java.desktop;
    requires org.apache.httpcomponents.httpclient;
    requires com.google.gson;
    requires java.net.http;
    requires com.google.api.services.storage;


    opens com.example.csc325_final_project.viewmodel to jdk.jsobject;
    exports com.example.csc325_final_project.viewmodel;
    opens com.example.csc325_final_project.view;
    exports com.example.csc325_final_project.view;
    exports com.example.csc325_final_project.model;
    opens com.example.csc325_final_project.model;
}