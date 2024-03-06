import java.util.Scanner;


public class uniquePrefix {
   static class TrieNode{
        TrieNode[] child=new TrieNode[256];
        int freq;
        TrieNode(){
            freq=1;
            for(int i=0;i<256;i++){
                child[i]=null;
            }
        }
    }
    static TrieNode root;
    static void insert(String str)
    {
        // Length of the URL
        int len = str.length();
        TrieNode pCrawl = root;

        // Traversing over the length of given str.
        for (int level = 0; level<len; level++)
        {
            // Get index of child node from current character
            // in str.
            int index = str.charAt(level);

            // Create a new child if not exist already
            if (pCrawl.child[index] == null)
                pCrawl.child[index] = new TrieNode();
            else
                (pCrawl.child[index].freq)++;

            // Move to the child
            pCrawl = pCrawl.child[index];
        }
    }
    static void findPrefixesUtil(TrieNode root, char[] prefix,
                                 int ind)
    {
        // Corner case
        if (root == null)
            return;

        // Base case
        if (root.freq == 1)
        {
            prefix[ind] = '\0';
            int i = 0;
            while(prefix[i] != '\0')
                System.out.print(prefix[i++]);
            System.out.print("  ");
            return;
        }

        for (int i=0; i<256; i++)
        {
            if (root.child[i] != null)
            {
                prefix[ind] = (char) i;
                findPrefixesUtil(root.child[i], prefix, ind+1);
            }
        }
    }
    // Function to print all prefixes that uniquely
    // represent all words in arr[0..n-1]
    static void findPrefixes(String arr[], int n)
    {
        // Construct a Trie of all words
        root = new TrieNode();
        root.freq = 0;
        for (int i = 0; i<n; i++)
            insert(arr[i]);

        // Create an array to store all prefixes
        char[] prefix = new char[512];

        // Print all prefixes using Trie Traversal
        findPrefixesUtil(root, prefix, 0);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String [] arr=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        findPrefixes(arr,n);
    }
}
