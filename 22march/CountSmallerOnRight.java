import java.util.Arrays;

public class CountSmallerOnRight {
    public static int[] countSmallerOnRight(int[] arr) {
        int n = arr.length;
        int[] count = new int[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSortAndCount(arr, indexes, count, 0, n - 1);
        return count;
    }

    private static void mergeSortAndCount(int[] arr, int[] indexes, int[] count, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortAndCount(arr, indexes, count, left, mid);
            mergeSortAndCount(arr, indexes, count, mid + 1, right);
            mergeAndCount(arr, indexes, count, left, mid, right);
        }
    }

    private static void mergeAndCount(int[] arr, int[] indexes, int[] count, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;
        while (i <= mid && j <= right) {
            if (arr[indexes[i]] > arr[indexes[j]]) {
                temp[k++] = indexes[j++];
                rightCount++;
            } else {
                count[indexes[i]] += rightCount;
                temp[k++] = indexes[i++];
            }
        }
        while (i <= mid) {
            count[indexes[i]] += rightCount;
            temp[k++] = indexes[i++];
        }
        while (j <= right) {
            temp[k++] = indexes[j++];
        }
        System.arraycopy(temp, 0, indexes, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5};
        int[] count = countSmallerOnRight(arr);
        System.out.println(Arrays.toString(count)); // Output: [2, 1, 0, 0]
    }
}
