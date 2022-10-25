package pk.addressbook.tests;

import org.junit.Test;
import pk.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        app.getNavigationHelper().goToEditPage();
        app.getContactHelper().fillTheContactForm(new ContactData("Tom","Li", "Tokyo", "3728","modified@mail.com"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToContactPage();
    }
}
