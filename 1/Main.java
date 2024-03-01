//1. Given a binary tree A, flatten it to a linked list in-place.
import java.util.Scanner;
import java.util.Stack;

public class Main {
    // Node class representing each node in the binary tree
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Pair class to keep track of the state of each node during traversal
    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static Node node = null; // Global variable to store the root node of the binary tree

    // Method to insert nodes into the binary tree
    public static void insert(String[] arr) {
        // Check if root is not null
        if (!arr[0].equals("null")) {
            node = new Node(Integer.parseInt(arr[0]), null, null);
        }
        Pair rn = new Pair(node, 0); // Create a pair for root node
        Stack<Pair> st = new Stack<>(); // Stack to perform iterative traversal
        st.push(rn); // Push root node pair onto the stack
        int idx = 0; // Index to traverse the input array
        while (!st.empty()) {
            Pair top = st.peek(); // Get the top pair from the stack
            if (top.state == 0) { // If the state is 0, process left child
                idx++;
                if (idx < arr.length && !arr[idx].equals("null")) {
                    // Create left child node and push its pair onto stack
                    Node nl = new Node(Integer.parseInt(arr[idx]), null, null);
                    top.node.left = nl;
                    Pair lp = new Pair(nl, 0);
                    st.push(lp);
                } else {
                    top.node.left = null; // If input is "null", set left child to null
                }
                top.state++;
            } else if (top.state == 1) { // If the state is 1, process right child
                idx++;
                if (idx < arr.length && !arr[idx].equals("null")) {
                    // Create right child node and push its pair onto stack
                    Node nr = new Node(Integer.parseInt(arr[idx]), null, null);
                    top.node.right = nr;
                    Pair lp = new Pair(nr, 0);
                    st.push(lp);
                } else {
                    top.node.right = null; // If input is "null", set right child to null
                }
                top.state++;
            } else {
                st.pop(); // If both left and right children are processed, pop the pair from stack
            }
        }
    }

    // Method to perform inorder traversal of the binary tree
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Method to flatten the binary tree into a linked list
    public static Node flatten(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node pred = curr.left;
                while (pred.right != null)
                    pred = pred.right;
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Read the number of elements in the input array
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next(); // Read the input array
        }
        insert(arr); // Insert elements into the binary tree
        inorder(node); // Perform inorder traversal of the binary tree
        System.out.println(); // Print newline
        Node root = flatten(node); // Flatten the binary tree into a linked list
        while (root != null) {
            System.out.print(root.data + " "); // Print the flattened linked list
            root = root.right;
        }
    }
}
