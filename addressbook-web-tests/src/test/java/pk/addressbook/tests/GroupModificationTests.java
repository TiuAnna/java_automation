package pk.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("new group").withHeader("new header").withFooter("new footer"));
        }
    }
    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.group().all();
        GroupData groupToModify = before.iterator().next();
        GroupData group = new GroupData()
                .withId(groupToModify.id()).withName("modified group").withHeader("new header").withFooter("modified footer");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(groupToModify);
        before.add(group);
        Assert.assertEquals(before, after);
    }


}
