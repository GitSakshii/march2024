import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;

    TrieNode() {
        children = new HashMap<>();
    }
}

public class DistinctSubstringsUsingTrie {
    static TrieNode root;

    public static void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
    }

    public static int countDistinctSubstrings(String s) {
        root = new TrieNode();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            insert(s.substring(i)); // Insert all suffixes into trie
        }
        return countNodes(root);
    }

    public static int countNodes(TrieNode node) {
        int count = 1; // Count current node
        for (TrieNode child : node.children.values()) {
            count += countNodes(child); // Recursively count nodes in children
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String[] input = new String[n];
        for(int i=0;i<n;i++){
            input[i]=scanner.nextLine();
        }
        for (int i = 0; i < input.length; i++) {
            System.out.println(countDistinctSubstrings(input[i]));
        }


    }
}
