import java.util.ArrayList;
import java.util.Scanner;

public class Q6ArrayList {
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
        System.out.println("Enter element to replace second element");
        String newelement=scanner.nextLine();
        if(n>2){
            arrayList.set(1,newelement);
        }
        System.out.println("Array list after updating");
        for(String element:arrayList)
        {
            System.out.println(element);
        }

    }
}
