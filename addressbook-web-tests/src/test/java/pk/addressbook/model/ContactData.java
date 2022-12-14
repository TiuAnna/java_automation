package pk.addressbook.model;

import java.io.File;
import java.util.Objects;

public final class ContactData {
    private int id = Integer.MAX_VALUE;
    private String name;
    private String lastName;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String mail;
    private String mail2;
    private String mail3;


    private File photo;

    private String group;


    private String allPhones;
    private String allMails;

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

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String number) {
        this.homePhone = number;
        return this;
    }

    public ContactData withMobilePhone(String number) {
        this.mobilePhone = number;
        return this;
    }

    public ContactData withWorkPhone(String number) {
        this.workPhone = number;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withEmail(String mail) {
        this.mail = mail;
        return this;
    }
    public ContactData withSecondEmail(String mail2) {
        this.mail2 = mail2;
        return this;
    }
    public ContactData withThirdEmail(String mail3) {
        this.mail3 = mail3;
        return this;
    }
    public ContactData withAllEmails(String allMails) {
        this.allMails = allMails;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
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

    public String homePhone() {
        return homePhone;
    }
    public String mobilePhone() {
        return mobilePhone;
    }
    public String workPhone() {
        return workPhone;
    }

    public String mail() {
        return mail;
    }

    public String mail2() {
        return mail2;
    }

    public String mail3() {
        return mail3;
    }

    public String group() {
        return group;
    }
    public String allPhones() {
        return allPhones;
    }

    public String allMails() {
        return allMails;
    }
    public File photo() {
        return photo;
    }


}
