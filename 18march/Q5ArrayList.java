import java.util.ArrayList;
import java.util.Scanner;

public class Q5ArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        //Taking Input From User
        System.out.println("Enter the size of array List");
        int n=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Elements");
        for(int i=0;i<n;i++){
            arrayList.add(scanner.nextLine());
        }
        //Enter element to be searched
        System.out.println("Enter the element to be searched:");
        String searchElement=scanner.nextLine();
        int index=arrayList.indexOf(searchElement);
        if(index!=-1)
        {
            System.out.println("Element found at index "+index);
        }else {
            System.out.println("Element not found!!");
        }

    }
}
