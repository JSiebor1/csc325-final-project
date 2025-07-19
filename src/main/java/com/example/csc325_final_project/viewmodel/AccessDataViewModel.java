package com.example.csc325_final_project.viewmodel;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class AccessDataViewModel {

	// this is for the table view on record list

	private StringProperty fName = new SimpleStringProperty();
	private StringProperty lName = new SimpleStringProperty();
	private StringProperty club = new SimpleStringProperty();
	private StringProperty position = new SimpleStringProperty();
	private StringProperty phoneNum = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	private StringProperty other = new SimpleStringProperty();


	public StringProperty fNameProperty() { return fName; }
	public String getFName() {return fName.get();}
	public StringProperty lNameProperty() { return lName; }
	public String getLName() {return lName.get();}
	public StringProperty clubProperty() { return club; }
	public String getClub() {return club.get();}
	public StringProperty positionProperty() { return position; }
	public String getPosition() {return position.get();}
	public StringProperty phoneNumProperty() { return phoneNum; }
	public String getPhoneNum() {return phoneNum.get();}
	public StringProperty emailProperty() { return email; }
	public String getEmail() {return email.get();}
	public StringProperty otherProperty() {return other;}
	public String getOther() {return other.get();}

}
