import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Q2LinkedList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        LinkedList<Integer> list=new LinkedList<>();
        System.out.println("Enter the size of linked list 1 ");

        int n=scanner.nextInt();
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++ )
        {
            int val=scanner.nextInt();
            list.add(val);
        }
        //Remove Dulplicates
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> uniqueList = new LinkedList<>();

        for (int num : list) {
            if (!set.contains(num)) {
                uniqueList.add(num);
                set.add(num);
            }
        }

        list.clear();
        list.addAll(uniqueList);
        //Print List
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
