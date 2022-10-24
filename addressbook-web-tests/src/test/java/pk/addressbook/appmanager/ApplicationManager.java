package pk.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pk.addressbook.model.ContactData;
import pk.addressbook.model.GroupData;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    public WebDriver driver;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    public void init() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("http://localhost/addressbook/");
        /*driver.manage().window().setSize(new Dimension(550, 691));*/
        login("admin", "secret");
    }

    private void login(String username, String password) {
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.id("LoginForm")).click();
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    public void stop() {
        driver.quit();
    }

    public void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).sendKeys(groupData.name());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).sendKeys(groupData.header());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    public void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    public void goToGroupPage() {
      driver.findElement(By.linkText("groups")).click();
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

    public void goToNewContactCreationPage() {
      driver.findElement(By.linkText("add new")).click();
    }
    public void deleteSelectedGroups() {
        driver.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        driver.findElement(By.cssSelector(".group:nth-child(6) > input")).click();
    }
}
