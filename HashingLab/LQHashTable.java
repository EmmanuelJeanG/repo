package application;

public class LQHashTable {
    private int[] table;
    private int size;

    public LQHashTable(int size) {
        this.size = size;
        this.table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
        
  
    }

    public int insert(int key) {
        int index = key % size; // i_p = key % N
        int quotient = key / size; // q = key / N
        int offset;
        int comparisons = 1; // Start counting at 1 (first check)


        if (quotient % size != 0) {
            offset = quotient;
        } else {
            offset = 19; //4k+3 prime
        }

        while (table[index] != -1) {
            index = (index + offset) % size;
            comparisons++;
        }
        table[index] = key;
        return comparisons;
    }

    public void display() {
        System.out.println("\nLQHashing Table:");
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            if (table[i] == -1) {
                System.out.println("Empty");
            } else {
                System.out.println(table[i]);
            }
        }
    }
}
