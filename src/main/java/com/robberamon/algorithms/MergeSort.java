package com.robberamon.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    private static int[] aux;

    private static void merge(int[] a, int lo, int mid, int hi, Comparisons comparisons) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (HelperMethods.less(aux[j], aux[i], comparisons)) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static int sort(int[] data) {
        Comparisons comparisons = new Comparisons();
        aux = new int[data.length];
        sort(data, 0, data.length - 1, comparisons);
        return comparisons.getComparisons();
    }

    private static void sort(int[] data, int lo, int hi, Comparisons comparisons) {
        if (hi <= lo) return;

        int mid = lo + (hi - lo)/2;
        sort(data, lo, mid, comparisons);
        sort(data, mid+1, hi, comparisons);
        merge(data, lo, mid, hi, comparisons);
    }


}
