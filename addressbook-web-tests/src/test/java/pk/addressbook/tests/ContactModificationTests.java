package pk.addressbook.tests;

import org.junit.Test;
import pk.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Nick", "Yellow", "LA",null, "thesecond@mail.com", "new group"), true);
        }
        app.getNavigationHelper().goToEditPage();
        app.getContactHelper().fillTheContactForm(new ContactData("Tom","Li", "Tokyo", "3728","modified@mail.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
    }
}
