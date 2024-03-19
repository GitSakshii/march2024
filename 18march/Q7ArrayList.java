import java.util.ArrayList;

public class Q7ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Initial capacity
        int initialCapacity = 3;
        arrayList.ensureCapacity(initialCapacity);

        // Adding elements to the ArrayList
        for (int i = 0; i <5; i++) {
            arrayList.add(i);
        }

        // Displaying the size of the ArrayList
        System.out.println("Size of ArrayList after adding elements: " + arrayList.size());

    }
}
