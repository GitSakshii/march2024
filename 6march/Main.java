import java.util.Arrays;
import java.util.Scanner;

//Assign stalls to k cows such that the minimum distance between any two of them is maximum possible
public class Main {
    public static boolean canWePlace(int[] arr,int distance,int k)
    {
        int cntCows=1;
        int last=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
           if(arr[i]-last>=distance){
               last=arr[i];
              cntCows++;
           }
        }
        if(cntCows>=k)return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter k");
        int k=sc.nextInt();
        int[] stalls=new int[n];
        System.out.println("Enter Position of Stalls");
        for(int i=0;i<n;i++){
            stalls[i]=sc.nextInt();
        }
        Arrays.sort(stalls);
        int max=stalls[n-1]-stalls[0];
        System.out.println(max);
        for(int i=1;i<max;i++){
            if(!canWePlace(stalls,i,k)) {
                System.out.println("Maximum minimum distance possible is:"+ (i-1));
                break;
            }
        }

    }
}
