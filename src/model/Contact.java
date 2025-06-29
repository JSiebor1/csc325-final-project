package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {
    private final StringProperty name;
    private final StringProperty phone;
    private final StringProperty email;

    public Contact(String name, String phone, String email) {
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty phoneProperty() { return phone; }
    public StringProperty emailProperty() { return email; }

    public String getName() { return name.get(); }
    public String getPhone() { return phone.get(); }
    public String getEmail() { return email.get(); }

    public void setName(String value) { name.set(value); }
    public void setPhone(String value) { phone.set(value); }
    public void setEmail(String value) { email.set(value); }
}
