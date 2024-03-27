import java.util.Scanner;
//Program to find the minimum time to paint some boards by k painters
public class Main {
    static int sum(int arr[], int from, int to)
    {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    // for n boards and k partitions
    static int partition(int arr[], int n, int k)
    {
        // base cases
        if (k == 1) // one partition
            return sum(arr, 0, n - 1);
        if (n == 1) // one board
            return arr[0];

        int best = Integer.MAX_VALUE;


        for (int i = 1; i <= n; i++)
            best = Math.min(
                    best, Math.max(partition(arr, i, k - 1),
                            sum(arr, i, n - 1)));

        return best;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int k=scanner.nextInt();
        System.out.println(partition(arr,n,k));
    }
}
