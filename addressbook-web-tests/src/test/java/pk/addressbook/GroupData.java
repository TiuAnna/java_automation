package pk.addressbook;

import java.util.Objects;

public record GroupData(String name, String header, String footer) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (GroupData) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.header, that.header) &&
                Objects.equals(this.footer, that.footer);
    }

    @Override
    public String toString() {
        return "GroupData[" +
                "name=" + name + ", " +
                "header=" + header + ", " +
                "footer=" + footer + ']';
    }

}