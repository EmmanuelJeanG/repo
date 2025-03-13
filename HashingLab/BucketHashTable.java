package application;

import java.util.LinkedList;

public class BucketHashTable {
    private LinkedList<Integer>[] table;
    private int size;

    @SuppressWarnings("unchecked")
	public BucketHashTable(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>(); 
        }
    }

    public void insert(int key) {
        int index = key % size; // i_p = key % N
        table[index].add(key); 
    }

    public void display() {
        System.out.println("\nBucket Hashing Table:");
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("Empty");
            } else {
                System.out.println(table[i]); 
            }
        }
    }
}
