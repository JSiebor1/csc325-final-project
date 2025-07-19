/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.csc325_final_project.model;

// This is for add records !!

public class RecordData {
    private String fName;
    private String lName;
    private String club;
    private String position;
    private String phoneNum;
    private String email;
    private String other;

    public RecordData() {}

    public RecordData(String fName, String lName, String club, String position, String phoneNum, String email, String other) {
        this.fName = fName;
        this.lName = lName;
        this.club = club;
        this.position = position;
        this.phoneNum = phoneNum;
        this.email = email;
        this.other = other;
    }

    public String getFName() { return fName; }
    public String getLName() { return lName; }
    public String getClub() { return club; }
    public String getPosition() { return position; }
    public String getPhoneNum() { return phoneNum; }
    public String getEmail() { return email; }
    public String getOther() { return other; }

    public void setFName(String fName) { this.fName = fName; }
    public void setLName(String lName) { this.lName = lName; }
    public void setClub(String club) {this.club = club; }
    public void setPosition(String position) { this.position = position; }
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
    public void setEmail(String email) { this.email = email; }
    public void setOther(String other) { this.other = other; }
}

