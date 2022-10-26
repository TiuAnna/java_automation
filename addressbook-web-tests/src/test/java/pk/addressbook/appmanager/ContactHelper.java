package pk.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pk.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {

        super(driver);
    }

    public void submitNewContactCreation() {
        click(By.name("submit"));
    }

    public void fillTheContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.name());
        type(By.name("lastname"), contactData.lastName());
        type(By.name("address"), contactData.address());
        type(By.name("home"), contactData.telNumber());
        type(By.name("email"), contactData.mail());
        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.group());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptAlertForDeletion() {
        acceptAlert("Delete 1 addresses?");
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
