import java.util.Scanner;

//You are given two strings, 'str1' and 'str2'. You have to find the length of the
// longest common  substring.
public class Main {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store LCS lengths
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0; // Initialize a variable to store the maximum LCS length

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters at the current indices are the same, extend the LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val); // Update the maximum LCS length
                } else {
                    dp[i][j] = 0; // Reset LCS length if characters don't match
                }
            }
        }

        return ans; // Return the length of the Longest Common Substring (LCS)
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Taking input from the user
        String str1=scanner.nextLine();
        String str2=scanner.nextLine();
        //Caalling method to find the length of longest common substring
        System.out.println(lcs(str1,str2));
    }
}
