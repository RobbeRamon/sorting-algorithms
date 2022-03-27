package com.robberamon.algorithms;

public class QuickSort {
    public static int sort(int[] data) {
        HelperMethods.shuffel(data);
        Comparisons comparisons = new Comparisons();
        sort(data, 0, data.length-1, comparisons);
        return comparisons.getComparisons();
    }

    private static void sort(int[] data, int lo, int hi, Comparisons comparisons) {

        if (hi <= lo) return;
        int j = partition(data, lo, hi, comparisons);

        sort(data, lo, j-1, comparisons);
        sort(data, j+1, hi, comparisons);
    }

    private static int partition(int[] data, int lo, int hi, Comparisons comparisons) {
        int i = lo, j = hi + 1;
        int v = data[lo];

        while(true) {
            while(HelperMethods.less(data[++i], v, comparisons)) if (i == hi) break;
            while(HelperMethods.less(v, data[--j], comparisons)) if (j == lo) break;
            if (i >= j) break;
            HelperMethods.exch(data, i, j);
        }

        HelperMethods.exch(data, lo, j);
        return j;
    }
}
