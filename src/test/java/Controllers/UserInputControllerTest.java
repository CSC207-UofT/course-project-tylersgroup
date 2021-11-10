package Controllers;


import com.example.spottywebapp.Controllers.UserInputController;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;

public class UserInputControllerTest {
    @Before("")
    public void setUp(){
    }

    @After("")
    public void tearDown(){
    }

    @Test
    public void testSplitUserInput() {
        ArrayList<String> actual = UserInputController.splitUserInput("hi there my name is june");
        String [] expectedArray = {"hi", "there", "my", "name", "is", "june"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(expectedArray));
        assert(expected.equals(actual));

    }

}