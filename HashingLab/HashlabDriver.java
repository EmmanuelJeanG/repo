package application;

public class HashlabDriver {
    public static void main(String[] args) {
        int[] keys = {27, 53, 13, 10, 138, 109, 49, 174, 26, 24};

        LQHashTable lqTable = new LQHashTable(13);
        BucketHashTable bucketTable = new BucketHashTable(10);

        System.out.println("Inserting keys into LQHashing..");
        for (int key : keys) {
            int comparisons = lqTable.insert(key);
            System.out.println("Inserted " + key + " with " + comparisons + " comparisons.");
        }

        System.out.println("\nInserting keys into Bucket Hashing..");
        for (int key : keys) {
            bucketTable.insert(key);
        }

        lqTable.display();
        bucketTable.display();
    }
}
