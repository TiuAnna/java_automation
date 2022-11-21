package pk.addressbook.model;

import java.util.Objects;

public final class ContactData {
    private int id;
    private final String name;
    private final String lastName;
    private final String address;
    private final String telNumber;
    private final String mail;
    private final String group;

    public ContactData(String name, String lastName, String address, String telNumber, String mail, String group) {
        this.id = 0;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.telNumber = telNumber;
        this.mail = mail;
        this.group = group;
    }

    public ContactData(int id, String name, String lastName, String address, String telNumber, String mail, String group) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.telNumber = telNumber;
        this.mail = mail;
        this.group = group;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
    public int id() {
        return id;
    }
    public String name() {
        return name;
    }

    public String lastName() {
        return lastName;
    }

    public String address() {
        return address;
    }

    public String telNumber() {
        return telNumber;
    }

    public String mail() {
        return mail;
    }

    public String group() {
        return group;
    }


}