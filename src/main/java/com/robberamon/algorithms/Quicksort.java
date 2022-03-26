package com.robberamon.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quicksort {
    /*public static int sort(int[] data) {
        HelperMethods.shuffel(data);
        return sort(data, 0, data.length-1);
    }

    private static int sort(int[] data, int lo, int hi) {
        if (hi <= lo) return 0;
        int j = partition(data, lo, hi);

        int comparisons = 0;

        comparisons = sort(data, lo, j-1);
        comparisons += sort(data, j+1, hi);

        return comparisons;
    }

    private static void partition(int[] data, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = data[lo];

        int comparisons = 0;

        while(true) {
            while(HelperMethods.less(data[++i], v)) {
                comparisons++;
            }
        }
    }*/
}
