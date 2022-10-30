package pk.addressbook.tests;

import org.junit.Test;
import org.testng.Assert;
import pk.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("new group", "new header", "new footer"));
        }
        if (before == 0) {
            app.getGroupHelper().selectGroup(before);
        } else {
            app.getGroupHelper().selectGroup(before - 1);
        }
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("modified group", "new header", "modified footer"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        if (before == 0) {
            Assert.assertEquals(after, 1);
        } else {
            Assert.assertEquals(after, before);
        }
    }
}
