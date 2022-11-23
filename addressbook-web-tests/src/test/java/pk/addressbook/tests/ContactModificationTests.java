package pk.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

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
        Set<ContactData> before = app.contact().all();
        ContactData contactToModify = before.iterator().next();
        ContactData contact = new ContactData().withId(contactToModify.id()).withName("Tom").withLastName("Li")
                .withAddress("Tokyo").withTelNumber("3728").withMail("modified@mail.com");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(contactToModify);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}