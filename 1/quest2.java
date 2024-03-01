//2.Given a binary tree
//struct TreeLinkNode {
//TreeLinkNode *left;
//TreeLinkNode *right;
//TreeLinkNode *next;
//    }
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//Initially, all next pointers are set to NULL.
class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class quest2 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        // Start with the root node
        TreeLinkNode levelStart = root;

        // Traverse the tree level by level
        while (levelStart != null) {
            // Initialize the current node to the start of the current level
            TreeLinkNode curr = levelStart;

            // Traverse the current level and update the next pointers
            while (curr != null) {
                // Update the next pointer of the left child
                if (curr.left != null) {
                    if (curr.right != null) {
                        curr.left.next = curr.right;
                    } else {
                        curr.left.next = getNextRight(curr);
                    }
                }

                // Update the next pointer of the right child
                if (curr.right != null) {
                    curr.right.next = getNextRight(curr);
                }

                // Move to the next node in the current level
                curr = curr.next;
            }

            // Move to the start of the next level
            levelStart = getNextLevelStart(levelStart);
        }
    }

    //  function to get the next right node at the same level
    private TreeLinkNode getNextRight(TreeLinkNode node) {
        TreeLinkNode temp = node.next;
        while (temp != null) {
            if (temp.left != null) {
                return temp.left;
            }
            if (temp.right != null) {
                return temp.right;
            }
            temp = temp.next;
        }
        return null;
    }

    //  function to get the start of the next level
    private TreeLinkNode getNextLevelStart(TreeLinkNode node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }

    // Main function to demonstrate the solution
    public static void main(String[] args) {
        // Example input tree
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        // Create an instance of Solution
            quest2 quest = new quest2();

        // Populate the next pointers
        quest.connect(root);

        // Print the next pointers
        printNextPointers(root);
    }

    //  function to print the next pointers
    private static void printNextPointers(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode curr = root;
            while (curr != null) {
                System.out.print(curr.val);
                if (curr.next != null) {
                    System.out.print(" -> ");
                }
                curr = curr.next;
            }
            System.out.println();
            root = root.left;
        }
    }
}
