import java.util.ArrayList;
import java.util.Scanner;

public class Q4ArrayList {
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
        System.out.println("Enter the index of element to be removed");
        int idx=scanner.nextInt();
        if(arrayList.size()>idx){
        arrayList.remove(idx);
    }
        else{
            System.out.println("Index out of bound!!");
        }
        System.out.println("Element removed successfully !!");
        System.out.println("ArrayList After removal of element :");
        for(String element:arrayList){
            System.out.println(element);
        }
    }
}
