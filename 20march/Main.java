public class Main {
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        // Rearrange the array
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive integers from 1 to N are present
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, -1, 1};
        int[] arr2 = {0, 1, 2, 3, 4};

        System.out.println(firstMissingPositive(arr1));  // Output: 2
        System.out.println(firstMissingPositive(arr2));  // Output: 5
    }
}
