package application;

public class ArraySum {
    public int sumOfArray(Integer[] a, int index) {
        if (index < 0) {
            return 0; // Base case
        }
        return a[index] + sumOfArray(a, index - 1); // Recursive case
    }
}
