import java.util.Scanner;

public class maxSum {
    public static int maxSumNoAdjacent(int[][] A) {
        // Get the size of the grid
        int n = A[0].length;

        // Create a dp array to store maximum sums
        int[] dp = new int[n + 2];

        // Fill dp array iteratively
        for (int i = n - 1; i >= 0; i--) {
            // Calculate maximum sum including and excluding current element
            int incl = Math.max(A[0][i], A[1][i]) + dp[i + 2];
            int excl = dp[i + 1];

            // Store the maximum of incl and excl for current position
            dp[i] = Math.max(incl, excl);
        }

        // Return the maximum sum
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix =new int[2][n];
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println(maxSumNoAdjacent(matrix));

    }
}
