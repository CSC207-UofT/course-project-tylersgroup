package HeplerClasses;

import java.util.ArrayList;
import java.util.List;

public class TreeGenerator {

    public static Tree generateTree(ArrayList<String> wordList) {
        Tree songTree = new Tree();
        List<String> list = (List<String>) wordList;
        for (int i = list.size(); i > 0; i--) {
            List<String> newList = list.subList(0, i);
            System.out.println(newList);
        }
        return songTree;
    }

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("one");
        wordList.add("two");
        wordList.add("three");
        wordList.add("four");
        Tree songTree = TreeGenerator.generateTree(wordList);

    }
}
