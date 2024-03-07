import java.util.Scanner;

public class study {
    //A function to check if all chapters could be completed for a particular value of max
    public static Boolean canAllocate(int[] arr,int max,int n){
        int cntdays=1,time=arr[0];
        int m=arr.length;
        for(int i=1;i<m;i++){
            if(arr[i]+time<=max){
                time=arr[i]+time;
            }else
            {
               cntdays++;
               time=arr[i];
            }
        }
        if(cntdays==n)return true;
       return false;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int [] arr=new int[m];
        int max=0,sum=0;
        for(int i=0;i<m;i++){
            arr[i]=scanner.nextInt();
            sum=sum+arr[i];
            max=Math.max(max,arr[i]);
        }
        // Iterate from 'max' to 'sum' to find the minimum value of maximum amount of time for which ayush studies
        for(int i=max;i<=sum;i++){
            if(canAllocate(arr,i,n)){
                System.out.println(i);
                break;
            }
        }

    }
}
