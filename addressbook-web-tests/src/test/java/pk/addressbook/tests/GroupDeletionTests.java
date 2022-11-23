package pk.addressbook.tests;// Generated by Selenium IDE

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;


public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("new group"));
        }
    }
    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.group().all();
        GroupData groupToDelete = before.iterator().next();
        app.group().delete(groupToDelete);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(groupToDelete);
        Assert.assertEquals(before, after);
        
    }


}
