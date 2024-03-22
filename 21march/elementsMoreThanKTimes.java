import java.io.*;
import java.util.*;

public class elementsMoreThanKTimes{

    public static List<Integer> findElements(int[] arr, int K) {
        int N = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

        // Finding frequency of each element in array
        for (int i = 0; i < N; i++) {
            if (!freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], 1);
            } else {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            }
        }

        // Finding elements that appear more than N/K times in the array
        List<Integer> reqElements = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() >= (N / K)) {
                reqElements.add(entry.getKey());
            }
        }
        return reqElements;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 2, 4, 3, 4};
        int K = 4;
        List<Integer> result = findElements(arr, K);
        System.out.println(result);
    }
}
