import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Burningtree {
    public static int findBurningTime(Node root, int startNode) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> burningTime = new HashMap<>();
        queue.offer(root);
        burningTime.put(root, 0);

        int maxTime = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentTime = burningTime.get(current);

            if (current.left != null) {
                queue.offer(current.left);
                burningTime.put(current.left, currentTime + 1);
                maxTime = Math.max(maxTime, currentTime + 1);
            }
            if (current.right != null) {
                queue.offer(current.right);
                burningTime.put(current.right, currentTime + 1);
                maxTime = Math.max(maxTime, currentTime + 1);
            }
        }

        return maxTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nodesInput = scanner.nextLine().trim().split("\\s+");
        int startNode = Integer.parseInt(scanner.nextLine().trim());

        // Build the binary tree
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodesInput[0]));
        queue.offer(root);

        for (int i = 1; i < nodesInput.length; i += 2) {
            Node current = queue.poll();
            if (!nodesInput[i].equals("-1")) {
                current.left = new Node(Integer.parseInt(nodesInput[i]));
                queue.offer(current.left);
            }
            if (!nodesInput[i + 1].equals("-1")) {
                current.right = new Node(Integer.parseInt(nodesInput[i + 1]));
                queue.offer(current.right);
            }
        }

        // Find burning time
        int burningTime = findBurningTime(root, startNode);
        System.out.println(burningTime);
    }
}
