import java.util.ArrayList;
import java.util.Scanner;

public class Q3ArrayList {
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
        System.out.println("Enter the index of element to be updated");
        int idx=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new value:");
        String newValue=scanner.nextLine();
        arrayList.set(idx,newValue);
        System.out.println("updated array is:");
        for(String element:arrayList)
        {
            System.out.println(element);
        }
    }
}
