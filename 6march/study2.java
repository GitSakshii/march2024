import java.util.Scanner;
//Optimized solution using binary search
public class study2 {
    public static int canAllocate(int[] arr,int max){
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
        return cntdays;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int [] arr=new int[m];
        int low=0,high=0;
        for(int i=0;i<m;i++){
            arr[i]=scanner.nextInt();
            high=high+arr[i];
            low=Math.max(low,arr[i]);
        }

       while(low<=high){
          int mid=(low+high)/2;
          int days=canAllocate(arr,mid);
          if(days<=n){
              high=mid-1;
          }
          else{
              low=mid+1;
          }

       }
        System.out.println(low);
    }
}
