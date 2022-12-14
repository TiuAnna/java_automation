package pk.addressbook.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    public WebDriver driver;

    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    public NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    JavascriptExecutor js;
    private Browser browser;

    public ApplicationManager(Browser browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(Browser.FIREFOX)) {
        driver = new FirefoxDriver();
        } else if (browser.equals(Browser.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.EDGE)) {
            driver = new EdgeDriver();
        }
        js = (JavascriptExecutor) driver;
        Map<String, Object> vars = new HashMap<String, Object>();
        driver.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        /*driver.manage().window().setSize(new Dimension(550, 691));*/
        sessionHelper.login("admin", "secret");
    }



    public void stop() {
        driver.quit();
    }



    public ContactHelper contact() {
        return contactHelper;
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}
