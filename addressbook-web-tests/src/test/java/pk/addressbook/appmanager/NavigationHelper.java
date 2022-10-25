package pk.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupPage() {
      click(By.linkText("groups"));
    }
    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void goToNewContactCreationPage() {
      click(By.linkText("add new"));
    }

    public void goToHomePage() {
        click(By.linkText("home"));
    }

    public void goToEditPage() {
        click(By.cssSelector(".center:nth-child(8) img"));
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }
}
