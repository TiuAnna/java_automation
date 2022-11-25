package pk.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContact(new ContactData().withName("Nick").withLastName("Yellow").withAddress("LA")
                    .withHomePhone("111 03").withMobilePhone("+333").withWorkPhone("2-2-2")
                    .withEmail("thesecond@mail.com").withGroup(app.contact().getGroupName()), true);
        }
    }

    @Test
    public void testContactInfo() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.allPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.allMails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.address(), equalTo(contactInfoFromEditForm.address()));
    }

    private String mergeEmails(ContactData contact) {
        return Stream.of(contact.mail(), contact.mail2(), contact.mail3()).filter((s) -> !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Stream.of(contact.homePhone(), contact.mobilePhone(), contact.workPhone()).filter((s) -> !s.equals(""))
                .map(ContactInfoTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }

}