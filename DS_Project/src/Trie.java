import java.util.ArrayList;

public class Trie {
    static String Alphabet = "abcdefghijklmnopqrstuvwxyz";
    static TrieNode trieroot = new TrieNode();

    // Insert restaurant name into trie tree
    public void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = trieroot;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    // Search trie tree for restaurant with prefix key
    public static void searchTrie(String key) {
        TrieNode pCrawl = trieroot;
        String name = "";

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                System.out.println("NO restaurant found!");
                return;
            }
            name = name + Alphabet.charAt(index);
            pCrawl = pCrawl.children[index];
        }

        while (pCrawl != null && !pCrawl.isEndOfWord) {
            int j = 0;
            while (pCrawl.children[j] == null) {
                j++;
            }
            name = name + Alphabet.charAt(j);
            if (pCrawl.children[j].isEndOfWord)
                break;
            pCrawl = pCrawl.children[j];
        }

        System.out.println(name);
    }

    // check if the root is empty
    static boolean isEmpty(TrieNode root) {
        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    //remove restaurant from trie tree
    public TrieNode removeTrie(TrieNode root, String key, int depth) {
        if (root == null)
            return null;
        if (depth == key.length()) {

            if (root.isEndOfWord)
                root.isEndOfWord = false;

            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }
        int index = key.charAt(depth) - 'a';
        root.children[index] =
                removeTrie(root.children[index], key, depth + 1);
        if (isEmpty(root) && root.isEndOfWord == false) {
            root = null;
        }

        return root;
    }

}
