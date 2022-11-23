package pk.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pk.addressbook.model.ContactData;
import pk.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {

    NavigationHelper goTo = new NavigationHelper(driver);

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

    public void modify(ContactData contact) {
        goTo.editPageById(contact.id());
        fillTheContactForm(contact, false);
        submitContactModification();
        returnToContactPage();
    }

    public void selectContactById(int contactId) {
        driver.findElement(By.cssSelector("input[value='" + contactId + "'")).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptAlertForDeletion() {
        driver.switchTo().alert().accept();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void createContact(ContactData contactData, boolean groupField) {
        goTo.newContactCreationPage();
        fillTheContactForm(contactData, groupField);
        submitNewContactCreation();
        returnToContactPage();
    }

    public void delete(ContactData contactToDelete) {
        selectContactById(contactToDelete.id());
        deleteSelectedContacts();
        acceptAlertForDeletion();
        goTo.homePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public String getGroupName() {
        if (isElementPresent(By.xpath("//option[text()='modified group']"))) {
            return "modified group";
        } else {
            return "[none]";
        }
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> fields = element.findElements(By.tagName("td"));
            String lastName = fields.get(1).getText();
            String name = fields.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withName(name).withLastName(lastName));
        }
        return contacts;
    }
}
