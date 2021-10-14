package Controllers;

import java.util.ArrayList;
import java.util.Arrays;

public class UserInputProcessor {
    public UserInputProcessor () {
    }

    /**
     * A static method that splits the user input into a String Array
     *
     * @param userInput a sentence which the user wants to turn into a Playlist.
     * @return a list of the words that make up the userInput
     */
    public static ArrayList<String> splitUserInput (String userInput) {
        String[] splitArray = userInput.split("\\s+");
        return new ArrayList<>(Arrays.asList(splitArray));
    }
}
