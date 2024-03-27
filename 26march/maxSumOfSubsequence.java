import java.util.Scanner;
// Program to find the maximum sum of the subsequence with the constraint that
// no two elements are adjacent in the given array/list.
public class maxSumOfSubsequence {

    static int rec(int nums[], int idx,int N)
    {
        if (idx >= N)
            return 0;
        return Math.max(nums[idx] + rec(nums, idx + 2, N),
                rec(nums, idx + 1, N));
    }

   static int findMaxSum(int[] arr, int N)
    {
        return rec(arr, 0, N);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(findMaxSum(arr,n));
    }
}
