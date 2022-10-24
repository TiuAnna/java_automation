package pk.addressbook.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import pk.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();



    @Before
    public void setUp() {
        app.init();
    }

    @After
    public void tearDown() {
        app.stop();
    }

}
