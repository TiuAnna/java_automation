package pk.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pk.addressbook.model.GroupData;

public class GroupHelper {
    private WebDriver driver;
    public GroupHelper(WebDriver driver) {
        this.driver = driver;
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

    public void deleteSelectedGroups() {
        driver.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        driver.findElement(By.cssSelector(".group:nth-child(6) > input")).click();
    }
}
