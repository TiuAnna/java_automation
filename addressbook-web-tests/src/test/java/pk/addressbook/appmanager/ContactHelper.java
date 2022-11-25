package pk.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pk.addressbook.model.ContactData;
import pk.addressbook.model.Contacts;


import java.util.List;

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
        type(By.name("home"), contactData.homePhone());
        type(By.name("mobile"),contactData.mobilePhone());
        type(By.name("work"),contactData.workPhone());
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
        contactCache = null;
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
        contactCache = null;
        returnToContactPage();
    }

    public void delete(ContactData contactToDelete) {
        selectContactById(contactToDelete.id());
        deleteSelectedContacts();
        acceptAlertForDeletion();
        contactCache = null;
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

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> fields = element.findElements(By.tagName("td"));
            String lastName = fields.get(1).getText();
            String name = fields.get(2).getText();
            String allPhones = fields.get(5).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withName(name).withLastName(lastName)
                    .withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        goTo.editPageById(contact.id());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withId(contact.id()).withName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}
