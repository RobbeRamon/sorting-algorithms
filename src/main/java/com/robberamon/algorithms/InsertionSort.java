package com.robberamon.algorithms;


public class InsertionSort {
    public static int sort(int[] data) {
        Comparisons comparisons = new Comparisons();

        int n = data.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && HelperMethods.less(data[j], data[j-1], comparisons); j--) {
                HelperMethods.exch(data, j, j - 1);
            }
        }

        return comparisons.getComparisons();
    }
}
