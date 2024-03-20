import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {

    public static int longestSubarrayLength(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();

        // Iterate through the array and calculate the cumulative sum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // If the current sum is zero, update maxLength to include the subarray from index 0 to i
            if (sum == 0) {
                maxLength = i + 1;
            } else if (sumMap.containsKey(sum)) {
                // If the current sum has been encountered before, update maxLength
                maxLength = Math.max(maxLength, i - sumMap.get(sum));
            } else {
                // Store the current sum along with its index
                sumMap.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {95, -97, -387, -435, -5, -70, 897, 127, 23, 284};
        System.out.println("Length of the longest subarray: " + longestSubarrayLength(nums)); // Output: 5
    }
}
