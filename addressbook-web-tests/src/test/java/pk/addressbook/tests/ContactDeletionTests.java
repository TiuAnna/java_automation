package pk.addressbook.tests;

import org.junit.Test;
import pk.addressbook.model.ContactData;
import pk.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Nick", "Yellow", "LA",null, "thesecond@mail.com", app.getContactHelper().getGroupName()), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptAlertForDeletion();
        app.getNavigationHelper().goToHomePage();
    }
}
