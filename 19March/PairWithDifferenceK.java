import java.util.HashMap;
import java.util.Map;

public class PairWithDifferenceK {

    public static int countPairsWithDifferenceK(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through the array
        for (int num : nums) {
            // Calculate the difference between the current element and k
            int diff1 = num - k;
            int diff2 = num + k;

            // Check if the elements with difference k exist in the map
            if ((k != 0 && freqMap.containsKey(diff1)) || (freqMap.containsKey(diff2))) {
                // If k is non-zero, check for both positive and negative differences
                // If k is zero, check only for positive difference
                if (k != 0) {
                    count += freqMap.get(diff1);
                }
                count += freqMap.get(diff2);
            }

            // If k is 0, avoid counting the same element twice
            if (k == 0 && freqMap.get(num) > 1) {
                count--;
            }
        }

        // Each pair is counted twice, so divide by 2 to get the final count
        return count / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 1, 2, 4};
        int k1 = 3;
        System.out.println("Number of pairs with difference " + k1 + ": " + countPairsWithDifferenceK(nums1, k1)); // Output: 2

        int[] nums2 = {4, 4, 4, 4};
        int k2 = 0;
        System.out.println("Number of pairs with difference " + k2 + ": " + countPairsWithDifferenceK(nums2, k2)); // Output: 6
    }
}
