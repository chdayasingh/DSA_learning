package Tries;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
//        private Node[] children = new Node[ALPHABET_SIZE];
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        // Providing Abstraction to the user of Node class
        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch){
            return children.get(ch);
        }

        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);  // .values() return collection of values , then we will convert into node array
        }

        public boolean hasChildren(){
            return getChildren().length != 0;
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word){
        Node current = root;
        for(char ch: word.toCharArray()){
            // if children with char not exist create one
            if(!current.hasChild(ch)){
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if(word == null){
            return false;
        }

        var current = root;
        for(char ch: word.toCharArray()){
            if(!current.hasChild(ch)){
                return false;
            }
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    // Recursive
    public boolean contains1(String word){
        return contains1Helper(root, word, 0);
    }

    private boolean contains1Helper(Node root, String word, int index) {
        if(index == word.length()){
            return root.isEndOfWord;
        }
        char ch = word.charAt(index);
        if(!root.hasChild(ch)){
            return false;
        }
        return contains1Helper(root.getChild(ch), word, index+1);
    }

    public void preorderTraversal(){
        preorderTraversal(root);
    }
    
    private void preorderTraversal(Node root){
        System.out.println(root.value);

        for(Node child: root.getChildren()){
            preorderTraversal(child);
        }
    }
    public void postorderTraversal(){
        postorderTraversal(root);
    }
    private void postorderTraversal(Node root){
        for(Node child: root.getChildren()){
            postorderTraversal(child);
        }
        System.out.println(root.value);
    }


    public void remove(String word){
        remove(root, word, 0);
    }

    // post order traversal
    private void remove(Node root, String word, int index) {
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child == null){
            return;
        }
        remove(child, word, index+1);
        if(!child.isEndOfWord && !child.hasChildren()){
            root.removeChild(ch);
        }
    }

    public ArrayList<String> getAllWords(){
        ArrayList<String> words = new ArrayList<>();
        for(var child: root.getChildren()){
            getAllWordsHelper(child, "", words);
        }
        return words;
    }

    private void getAllWordsHelper(Node root, String prefix, ArrayList<String> words){
        prefix += root.value;
        if(root.isEndOfWord){
            words.add(prefix);
        }

        for(Node child : root.getChildren()){
            getAllWordsHelper(child, prefix, words);
        }
    }

    // Auto Completion
    public ArrayList<String> findWords(String prefix) {
        // finding the last node of prefix
        var current = root;
        for(char ch: prefix.toCharArray()){
            if(!current.hasChild(ch)){
                return null;
            }
            current = current.getChild(ch);
        }
        ArrayList<String> words = new ArrayList<>();
        getAllWordsHelper(current, prefix.substring(0, prefix.length()-1), words);
        return words;
    }

}
