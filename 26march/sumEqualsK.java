import java.util.Scanner;
//Program to find the number of ways of selecting the elements from the array
// such that the sum of chosen elements is equal to the target 'k'.
public class sumEqualsK {
    public static int findWays(int num[], int tar) {
        int n=num.length;

        return f(n-1,tar,num);
    }
    static int f(int ind,int s,int[] a){
        if(s==0) return 1;
        if(ind==0) return (a[0]==s)?1:0;
        int notTake=f(ind-1,s,a);
        int take=0;
        if(a[ind]<=s) take=f(ind-1,s-a[ind],a);
        return notTake+take;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Taking input from the user
        int n=scanner.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int k=scanner.nextInt();
        System.out.println(findWays(arr,k));
    }
}
