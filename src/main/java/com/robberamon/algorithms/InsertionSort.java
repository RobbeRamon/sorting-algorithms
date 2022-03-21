package com.robberamon.algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static int sort(int[] data) {
        int comparisons = 0;

        int n = data.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && HelperMethods.less(data[j], data[j-1]); j--) {
                comparisons++;
                HelperMethods.exch(data, j, j - 1);
            }
        }
        return comparisons;
    }
}
