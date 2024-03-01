//Merge K sorted linked lists
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Use PriorityQueue to sort lists by their head nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add the head nodes of all lists to the minHeap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // Create a dummy node to build the merged list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Iterate until all nodes are processed
        while (!minHeap.isEmpty()) {
            // Get the smallest node from minHeap
            ListNode minNode = minHeap.poll();
            // Add the smallest node to the merged list
            tail.next = minNode;
            tail = tail.next;
            // Move to the next node in the list
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return dummy.next;
    }

    //  function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sorted linked lists (k): ");
        int k = scanner.nextInt();
        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            System.out.print("Enter the number of elements in linked list " + (i + 1) + ": ");
            int n = scanner.nextInt();
            System.out.print("Enter the elements of linked list " + (i + 1) + " in sorted order: ");
            ListNode head = new ListNode(scanner.nextInt());
            ListNode current = head;
            for (int j = 1; j < n; j++) {
                current.next = new ListNode(scanner.nextInt());
                current = current.next;
            }
            lists[i] = head;
        }

        // Merge k sorted linked lists
        ListNode mergedList = mergeKLists(lists);

        // Print the merged sorted list
        System.out.println("Merged sorted list:");
        printList(mergedList);
    }
}

