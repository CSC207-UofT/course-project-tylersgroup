package Controllers;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserInputProcessorTest {
    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
    }

    @Test
    public void testSplitUserInput() {
        String [] actual = UserInputProcessor.splitUserInput("hi there my name is june");
        String [] expected = {"hi", "there", "my", "name", "is", "june"};
        assertArrayEquals(expected, actual);
    }

}