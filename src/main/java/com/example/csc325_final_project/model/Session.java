package com.example.csc325_final_project.model;


// to get the name for the user logged in

public class Session {
    private static String email;

    public static void setEmail(String userEmail) {
        email = userEmail;
    }

    public static String getEmail() {
        return email;
    }

    public static String getUsername() {
        if (email == null) return "";
        String username = email.split("@")[0];
        return username.substring(0, 1).toUpperCase() + username.substring(1);
    }
}