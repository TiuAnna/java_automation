package pk.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pk.addressbook.model.ContactData;
import pk.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
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
    public void goToNewContactCreationPage() {
        click(By.linkText("add new"));
    }
    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void createContact(ContactData contactData, boolean groupField) {
        goToNewContactCreationPage();
        fillTheContactForm(contactData, groupField);
        submitNewContactCreation();
        returnToContactPage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
    public String getGroupName() {
       if (isElementPresent(By.xpath("//option[text()='new group']"))) {
           return "new group";
       } else {
           return null;
       }
    }

    public ArrayList<ContactData> getContactList() {
        ArrayList<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, name, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
