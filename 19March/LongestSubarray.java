import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSubarray {

    public static int longestSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            // Update maxQueue with current max element
            while (!maxQueue.isEmpty() && nums[right] > nums[maxQueue.peekLast()])
                maxQueue.pollLast();
            maxQueue.offerLast(right);

            // Update minQueue with current min element
            while (!minQueue.isEmpty() && nums[right] < nums[minQueue.peekLast()])
                minQueue.pollLast();
            minQueue.offerLast(right);

            // If the absolute difference between max and min elements in the window > k
            // Move the left pointer to the right until it satisfies the condition
            while (nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > k) {
                if (maxQueue.peekFirst() == left)
                    maxQueue.pollFirst();
                if (minQueue.peekFirst() == left)
                    minQueue.pollFirst();
                left++;
            }

            // Update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 3, 7};
        int k = 3;
        System.out.println("Length of the longest subarray: " + longestSubarrayLength(nums, k)); // Output: 2
    }
}
