package pk.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pk.addressbook.model.GroupData;
import pk.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("new group").withHeader("new header").withFooter("new footer"));
        }
    }
    @Test
    public void testGroupModification() {
        Groups before = app.group().all();
        GroupData groupToModify = before.iterator().next();
        GroupData group = new GroupData()
                .withId(groupToModify.id()).withName("modified group").withHeader("new header").withFooter("modified footer");
        app.group().modify(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size()));

        assertThat(after, equalTo(before.without(groupToModify).withAdded(group)));
    }


}
