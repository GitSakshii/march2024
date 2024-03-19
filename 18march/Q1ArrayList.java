import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Q1ArrayList {
    public static void main(String[] args) {
        ArrayList<String>arrayList=new ArrayList<>();
        //Adding Elements to ArrayList
        arrayList.add("Red");
        arrayList.add("Green");
        arrayList.add("Orange");
        arrayList.add("White");
        System.out.println("Iterating through all elements");
        for(String element:arrayList)
        {
            System.out.println(element);
        }

    }
}
