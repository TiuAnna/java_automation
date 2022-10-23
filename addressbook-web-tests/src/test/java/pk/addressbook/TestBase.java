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
    private WebDriver driver;
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
}
