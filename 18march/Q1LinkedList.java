import java.util.LinkedList;
import java.util.Scanner;

public class Q1LinkedList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        LinkedList<Integer>l1=new LinkedList<>();
        System.out.println("Enter the size of linked list 1 ");

        int n=scanner.nextInt();
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++ )
        {
            int val=scanner.nextInt();
            l1.add(val);
        }
        LinkedList<Integer>l2=new LinkedList<>();
        System.out.println("Enter the size of linked list 1 ");

        int m=scanner.nextInt();
        System.out.println("Enter elements:");
        for(int i=0;i<m;i++ )
        {
            int val=scanner.nextInt();
            l2.add(val);
        }
        //Adding lists l1 and l2
        LinkedList<Integer>result=new LinkedList<>();
        int carry=0;
        while(!l1.isEmpty()||!l2.isEmpty()){
            int x = (!l1.isEmpty()) ? l1.removeLast() : 0;
            int y = (!l2.isEmpty()) ? l2.removeLast() : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            result.addFirst(sum % 10);
        }
        if (carry > 0) {
            result.addFirst(carry);
        }

        //Result is:
        for(int num:result){
            System.out.print(num+" ");
        }

    }
}
