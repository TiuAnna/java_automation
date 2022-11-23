package pk.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Comparator;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ContactData().withName("Nick").withLastName("Yellow").withAddress("LA")
                    .withMail("thesecond@mail.com").withGroup(app.contact().getGroupName()), true);
        }
    }

    @Test
    public void testContactModification() {
        ArrayList<ContactData> before = app.contact().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData().withId(before.get(index).id()).withName("Tom").withLastName("Li")
                .withAddress("Tokyo").withTelNumber("3728").withMail("modified@mail.com");
        app.contact().modify(index, contact);
        ArrayList<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<ContactData> byId = Comparator.comparingInt(ContactData::id);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}