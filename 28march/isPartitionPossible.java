//4.Problem statement
//You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.
//
//        For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.
//
//Follow Up:
//
//Can you solve this using not more than O(S) extra space, where S is the sum of all elements of the given array?
//Sample Input 1:
//        2
//        6
//        3 1 1 2 2 1
//        5
//        5 6 5 11 6
//Sample Output 1:
//        true
//        false

import java.util.*;

public class isPartitionPossible {
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false; // If sum is odd, cannot partition into two equal subsets
        }
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Size of the array
            int[] arr = new int[N]; // Array elements
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(canPartition(arr));
        }
        scanner.close();
    }
}

