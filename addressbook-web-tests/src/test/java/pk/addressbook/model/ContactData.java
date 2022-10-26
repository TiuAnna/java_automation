package pk.addressbook.model;

import java.util.Objects;

public record ContactData (String name, String lastName, String address, String telNumber, String mail, String group) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ContactData) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.address, that.address) &&
                Objects.equals(this.telNumber, that.telNumber) &&
                Objects.equals(this.mail, that.mail) &&
                Objects.equals(this.group, that.group);
    }

    @Override
    public String toString() {
        return "ContactData[" +
                "name=" + name + ", " +
                "lastName=" + lastName + ", " +
                "address=" + address + ", " +
                "telNumber=" + telNumber + ", " +
                "mail=" + mail + ", " +
                "group=" + group + ']';
    }

}