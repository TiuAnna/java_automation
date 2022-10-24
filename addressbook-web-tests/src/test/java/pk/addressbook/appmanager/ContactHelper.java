package pk.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pk.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContactHelper extends HelperBase {
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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.cssSelector(".left:nth-child(8) > input"));
    }
    public void acceptAlert() {
        assertThat(driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
        driver.switchTo().alert().accept();
    }
}
