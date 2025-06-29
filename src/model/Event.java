package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Event {
    private final StringProperty name;
    private final StringProperty date;
    private final StringProperty location;

    public Event(String name, String date, String location) {
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.location = new SimpleStringProperty(location);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty dateProperty() { return date; }
    public StringProperty locationProperty() { return location; }

    public String getName() { return name.get(); }
    public String getDate() { return date.get(); }
    public String getLocation() { return location.get(); }

    public void setName(String value) { name.set(value); }
    public void setDate(String value) { date.set(value); }
    public void setLocation(String value) { location.set(value); }
}
