package pk.addressbook.tests;

import org.junit.Test;
import org.testng.Assert;
import pk.addressbook.model.ContactData;

import java.util.ArrayList;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Nick", "Yellow", "LA",null, "thesecond@mail.com", app.getContactHelper().getGroupName()), true);
        }
        ArrayList<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptAlertForDeletion();
        app.getNavigationHelper().goToHomePage();
        ArrayList<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
