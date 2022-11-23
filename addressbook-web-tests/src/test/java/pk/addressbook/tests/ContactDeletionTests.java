package pk.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Set;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ContactData().withName("Nick").withLastName("Yellow").withAddress("LA")
                    .withMail("thesecond@mail.com").withGroup(app.contact().getGroupName()), true);
        }
    }

    @Test
    public void testContactDeletion() {
        Set<ContactData> before = app.contact().all();
        ContactData contactToDelete = before.iterator().next();
        app.contact().delete(contactToDelete);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(contactToDelete);
        Assert.assertEquals(before, after);
    }

}
