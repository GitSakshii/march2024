//        Given an array ‘ARR’, partition it into two subsets (possibly empty) such that their union is the original array. Let the sum of the elements of these two subsets be ‘S1’ and ‘S2’.

public class Main {
    public static int countPartitions(int[] arr, int n, int D) {
        int MOD = 1000000007;
        int s = 0;
        for (int num : arr) {
            s += num;
        }

        int[][][] dp = new int[n + 1][s + 1][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= s; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i + 1][j][k] = dp[i][j][k];
                    if (j - arr[i] >= 0) {
                        dp[i + 1][j][k] = (dp[i + 1][j][k] + dp[i][j - arr[i]][k ^ 1]) % MOD;
                    }
                }
            }
        }
        int count = 0;
        for (int diff = 0; diff <= D; diff++) {
            count = (count + dp[n][s][0]) % MOD;
            s++;
        }

        return count;
        }


    public static void main(String[] args) {
        int[][][] arr = {
                {{5, 2, 6, 4}, {4, 3}},
                {{1, 1, 1, 1}, {4, 0}},
                {{4, 6, 3}, {3, 1}},
                {{3, 1, 1, 2, 1}, {5, 0}},
                {{3, 2, 2, 5, 1}, {5, 1}}
        };
        for (int[][] a : arr) {
            System.out.println(countPartitions(a[0], a[1][0], a[1][1]));
        }

    }
}
