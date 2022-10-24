package pk.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pk.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
    public WebDriver driver;

    public ContactHelper(WebDriver driver) {

        super(driver);
    }
    public void submitNewContactCreation() {
        click(By.cssSelector("input:nth-child(87)"));
    }
    public void fillTheContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.name());
        type(By.name("lastname"),contactData.lastName());
        type(By.name("home"),contactData.telNumber());
        type(By.name("email"),contactData.mail());
    }
}
