package pk.addressbook.tests;

import org.junit.Test;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getContactHelper().acceptAlertForDeletion();
        app.getNavigationHelper().goToHomePage();
    }
}
