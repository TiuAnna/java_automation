package pk.addressbook.tests;// Generated by Selenium IDE
import org.junit.Test;
import pk.addressbook.model.ContactData;

public class CreateNewContactTest extends TestBase{
  
  @Test
  public void createNewContact() {
    app.getNavigationHelper().goToNewContactCreationPage();
    app.getContactHelper().fillTheContactForm(new ContactData("Nick", "Yellow", "LA","7-777-777", "thesecond@mail.com"));
    app.getContactHelper().submitNewContactCreation();
    app.getNavigationHelper().returnToContactPage();
  }

}
