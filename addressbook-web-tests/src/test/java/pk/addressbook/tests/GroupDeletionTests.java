package pk.addressbook.tests;// Generated by Selenium IDE
import org.junit.Test;


public class GroupDeletionTests extends TestBase{
  
  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().goToGroupPage();
  }

}
