package main.java.com.robberamon.algorithms;

public class SelectionSort {
    // returns the amount of comparisons that happened
    public static int sort(int[] data) {
        int comparisons = 0;
        int length = data.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j  < length; j++) {
                if (data[j] < (data[min])) {
                    min = j; // comparisons are happening here
                    comparisons++;
                }
            }
            int elem = data[i];
            data[i] = data[min];
            data[min] = elem;
        }
        return comparisons;
    }
}
