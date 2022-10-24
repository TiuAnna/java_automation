package pk.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pk.addressbook.model.ContactData;

public class ContactHelper {
    public WebDriver driver;

    public ContactHelper(WebDriver driver) {

        this.driver = driver;
    }
    public void submitNewContactCreation() {
        driver.findElement(By.name("theform")).click();
        driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }
    public void fillTheContactForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contactData.name());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contactData.lastName());
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys(contactData.telNumber());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(contactData.mail());
    }
}
