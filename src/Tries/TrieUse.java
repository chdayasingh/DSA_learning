package Tries;

public class TrieUse {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        System.out.println(trie.contains("can"));
        System.out.println(trie.contains1("card"));
//        trie.preorderTraversal();
//        trie.postorderTraversal();

//        trie.remove("can");
//        System.out.println("Done");

//        System.out.println(trie.getAllWords());
//        System.out.println(trie.findWords("car"));
    }
}
