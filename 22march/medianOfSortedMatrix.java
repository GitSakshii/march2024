import java.util.*;

public class medianOfSortedMatrix {
    public static int findMedian(int[][] matrix) {
        List<Integer> flattenedList = new ArrayList<>();

        // Flatten the matrix into a 1D array
        for (int[] row : matrix) {
            for (int num : row) {
                flattenedList.add(num);
            }
        }

        // Sort the 1D array
        Collections.sort(flattenedList);

        // Find the median
        int size = flattenedList.size();
        return flattenedList.get(size / 2);
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        System.out.println(findMedian(matrix1));  // Output: 5

        int[][] matrix2 = {{5},
                {1, 3},
                {1, 4, 6}};
        System.out.println(findMedian(matrix2));  // Output: 5 and 4
    }
}
