package pk.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.util.Collections;
//
//import static org.testng.Assert.assertEquals;

//    public void testArea() {
//        StringChanges s = new StringChanges();
//    }
//    public void shouldTakeUserInput() {
//        StringChanges t = new StringChanges();
//
//        String input = "Hello";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Assert.assertEquals();
//    }

public class FirstTest {
    @Test
    public void testArea() {
        Calculation var = new Calculation(6,7);
        var.answer();
       Assert.assertEquals(var.answer(), 42.0);
    }

}
