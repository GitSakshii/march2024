import java.util.ArrayList;
import java.util.List;

class MyHashSet {
    private List<Integer>[] buckets;
    private static final int SIZE = 769; // Prime number chosen for bucket size for better distribution

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        if (!contains(key))
            buckets[index].add(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }

    public int remove(int key) {
        int index = hash(key);
        if (contains(key)) {
            int idx = buckets[index].indexOf(key);
            buckets[index].remove(idx);
            return key;
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        // Sample input 1
        set.add(500);
        set.add(200);
        set.add(400);
        System.out.println(set.contains(200)); // True
        System.out.println(set.contains(600)); // False
        System.out.println(set.remove(200));   // 200

        // Sample input 2
        set.add(20);
        set.add(50);
        System.out.println(set.contains(30)); // False
        System.out.println(set.remove(20));   // 20
        System.out.println(set.remove(50));   // 50
    }
}
