package Controllers;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class UserInputProcessorTest {
    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }

    @Test
    public void testSplitUserInput() {
        ArrayList<String> actual = UserInputProcessor.splitUserInput("hi there my name is june");
        String [] expectedArray = {"hi", "there", "my", "name", "is", "june"};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(expectedArray));
        assert(expected.equals(actual));

    }

}