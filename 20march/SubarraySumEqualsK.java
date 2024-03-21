import java.sql.Array;
import java.util.*;

public class SubarraySumEqualsK {
    public static int countSubarraysWithSumK(int[] arr, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currSum = 0;

        // Initialize the hashmap with (0, 1) to consider subarrays starting from index 0
        map.put(0, 1);

        // Traverse the array and calculate cumulative sum
        for (int num : arr) {
            currSum += num;

            // If currSum - K exists in the hashmap, add its frequency to count
            if (map.containsKey(currSum - K)) {
                count += map.get(currSum - K);
            }

            // Update the frequency of currSum in the hashmap
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("Enter the value of k ");
        int k=scanner.nextInt();
        System.out.println(countSubarraysWithSumK(arr, k));  // Output: 2

        }
}
