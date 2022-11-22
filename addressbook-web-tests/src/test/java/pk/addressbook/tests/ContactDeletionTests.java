package pk.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.ContactData;

import java.util.ArrayList;

public class ContactDeletionTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ContactData("Nick", "Yellow", "LA", null, "thesecond@mail.com", app.contact().getGroupName()), true);
        }
    }
    @Test
    public void testContactDeletion() {
        ArrayList<ContactData> before = app.contact().getContactList();
        app.contact().selectContact(before.size() - 1);
        app.contact().deleteSelectedContacts();
        app.contact().acceptAlertForDeletion();
        app.goTo().homePage();
        ArrayList<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
