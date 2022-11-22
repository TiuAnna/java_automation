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
            app.contact().createContact(new ContactData("Nick", "Yellow", "LA", null, "thesecond@mail.com", app.contact().getGroupName()), true);
        }
    }

    @Test
    public void testContactModification() {
        ArrayList<ContactData> before = app.contact().getContactList();
        int index = before.size() - 1;
        ContactData contact = new ContactData(before.get(index).id(), "Tom", "Li", "Tokyo", "3728", "modified@mail.com", null);
        app.contact().modifyContact(index, contact);
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