package pk.addressbook.tests;

import org.junit.Test;
import org.testng.Assert;
import pk.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Nick", "Yellow", "LA",null, "thesecond@mail.com", app.getContactHelper().getGroupName()), true);
        }
        ArrayList<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToEditPage(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).id(),"Tom","Li", "Tokyo", "3728","modified@mail.com", null);
        app.getContactHelper().fillTheContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        ArrayList<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<ContactData> byId = Comparator.comparingInt(ContactData::id);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}