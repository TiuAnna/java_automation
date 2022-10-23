package pk.addressbook;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    JavascriptExecutor js;
    protected WebDriver driver;
    private Map<String, Object> vars;

    @Before
    public void setUp() {
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

    @After
    public void tearDown() {
      driver.quit();
    }

    protected void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).sendKeys(groupData.name());
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).sendKeys(groupData.header());
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    protected void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    protected void goToGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    protected void submitNewContactCreation() {
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }

    protected void fillTheContactForm(ContactData contactData) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).sendKeys(contactData.name());
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).sendKeys(contactData.lastName());
      driver.findElement(By.name("home")).click();
      driver.findElement(By.name("home")).sendKeys(contactData.telNumber());
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).sendKeys(contactData.mail());
    }

    protected void goToNewContactCreationPage() {
      driver.findElement(By.linkText("add new")).click();
    }
}
