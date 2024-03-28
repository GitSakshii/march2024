//        Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.
//
//        Note:
//        1. The sizes will range from 1 to ‘N’ and will be integers.
//
//        2. The sum of the pieces cut should be equal to ‘N’.
//
//        3. Consider 1-based indexing.

public class MaximumCostOfCuttingRods {
    public static int maximumCost(int[] A, int N) {
        int[] dp = new int[N + 1];

        // Loop through each possible length
        for (int i = 1; i <= N; i++) {
            int maxCost = Integer.MIN_VALUE;
            // Loop through each possible cut
            for (int j = 1; j <= i; j++) {
                // Calculate the cost for the current cut and add it to the maximum cost of the remaining length
                maxCost = Math.max(maxCost, A[j - 1] + dp[i - j]);
            }
            // Update dp[i] with the maximum value obtained from all possible cuts
            dp[i] = maxCost;
        }

        return dp[N];
}

    public static void main(String[] args) {
        int[][] arr = {
                {5, 2, 5, 7, 8, 10},
                {8, 3, 5, 8, 9, 10, 17, 17, 20},
                {6, 3, 5, 6, 7, 10, 12}
        };
        int[] lengths = {5, 8, 6};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(maximumCost(arr[i], lengths[i]));
        }

    }

}
