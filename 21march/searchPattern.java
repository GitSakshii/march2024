import java.util.*;

class searchPattern{

    static void searchPattern(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        int j;
        for (int i = 0; i <= n - m; i++) {

            for (j = 0; j < m; ++j) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("index = " + (i+1));
            }
        }
    }
    public static void main(String args[]) {

        String text = "ababacabab";
        String pattern = "aba";

        searchPattern(text, pattern);
    }
}