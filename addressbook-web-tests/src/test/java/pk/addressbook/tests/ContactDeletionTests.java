package pk.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.ContactData;
import pk.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData().withName("Nick").withLastName("Yellow").withAddress("LA")
                    .withMail("thesecond@mail.com").withGroup(app.contact().getGroupName()), true);
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData contactToDelete = before.iterator().next();
        app.contact().delete(contactToDelete);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() - 1));

        assertThat(after, equalTo(before.without(contactToDelete)));
    }

}
