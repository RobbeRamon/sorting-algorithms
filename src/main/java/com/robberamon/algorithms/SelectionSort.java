package com.robberamon.algorithms;

public class SelectionSort {
    // returns the amount of comparisons that happened
    public static int sort(int[] data) {
        Comparisons comparisons = new Comparisons();

        int length = data.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j  < length; j++) {
                if (HelperMethods.less(data[j], (data[min]), comparisons)) {
                    min = j;
                }
            }
            int elem = data[i];
            data[i] = data[min];
            data[min] = elem;
        }

        return comparisons.getComparisons();
    }
}
