package HeplerClasses;


import java.util.ArrayList;

public class Tree {

    static class Node {
        String value;
        ArrayList<Node> children;

        public Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
//    public Tree(ArrayList<String> wordList) {
//        String fullSentence = wordList.toString();
//        Node root = new Node(fullSentence);
//
//    }
}
