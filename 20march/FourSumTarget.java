import java.util.*;

public class FourSumTarget {
    public static String checkFourSum(int[] arr, int target) {
        int n = arr.length;
        Map<Integer, List<int[]>> pairSumMap = new HashMap<>();

        // Create a hashmap to store pair sums and their corresponding indices
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (!pairSumMap.containsKey(sum)) {
                    pairSumMap.put(sum, new ArrayList<>());
                }
                pairSumMap.get(sum).add(new int[]{i, j});
            }
        }

        // Iterate over all pairs of elements and check for the remaining sum in the hashmap
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int remainingSum = target - (arr[i] + arr[j]);
                if (pairSumMap.containsKey(remainingSum)) {
                    for (int[] pairIndices : pairSumMap.get(remainingSum)) {
                        int k = pairIndices[0];
                        int l = pairIndices[1];
                        if (k != i && k != j && l != i && l != j) {
                            return "Yes";
                        }
                    }
                }
            }
        }

        return "No";
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter n");
        int n=scanner.nextInt();
        int [] arr=new int[n];
        System.out.println("Enter the elements of the array" );
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println("Enter the Target sum:");
        int targetSum=scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(checkFourSum(arr, targetSum));
        }
    }
}
