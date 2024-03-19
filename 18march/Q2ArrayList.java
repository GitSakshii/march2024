import java.util.ArrayList;
import java.util.Scanner;

public class Q2ArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size of array List");
        int n=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Elements");
        for(int i=0;i<n;i++){
            arrayList.add(scanner.nextLine());
        }
        System.out.println("Enter the index of the element to retrieve");
        int i=scanner.nextInt();
        System.out.println("Result: "+arrayList.get(i));

    }
}
