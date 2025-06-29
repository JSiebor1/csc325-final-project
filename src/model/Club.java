package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Club {
    private final StringProperty name;
    private final StringProperty description;

    public Club(String name, String description) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty descriptionProperty() { return description; }

    public String getName() { return name.get(); }
    public String getDescription() { return description.get(); }

    public void setName(String value) { name.set(value); }
    public void setDescription(String value) { description.set(value); }
}
