package com.robberamon.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    // private static int[] aux;

    /*private static int merge(int[] a, int lo, int mid, int hi) {
        int comparisons = 0;

        int i = lo, j = mid + 1;

        if (hi - lo >= 0) System.arraycopy(a, lo, aux, lo, hi - lo);

        for (int k = lo; k <= hi; k++) {
            comparisons++;
            if (i < mid) a[k] = aux[j++];
            else if (j > hi){
                comparisons++;
                a[k] = aux[i++];
            }
            else if (HelperMethods.less(aux[j], aux[i])) {
                comparisons += 2;
                a[k] = aux[j++];
            }
            else a[k] = aux[i++];
        }

        return comparisons;
    }*/

    /*public static int sort(int[] data) {
        aux = new int[data.length];
        int amount =  sort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
        return amount;
    }*/

    /*private static int sort(int[] data, int lo, int hi) {
        if (hi <= lo) return 0;

        int mid = lo + (hi - lo)/2;
        int amount1 = sort(data, lo, mid);
        int amount2 = sort(data, mid+1, hi);
        int amount3 = merge(data, lo, mid, hi);
        return amount1 + amount2 + amount3;
    }*/

    private static int merge(int arr[], int l, int m, int r)
    {
        int comparisons = 0;

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return comparisons;
    }

    private static int sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            int comparisons1 = sort(arr, l, m);
            int comparisons2 = sort(arr, m + 1, r);

            int totalComparisons = comparisons1 + comparisons2;

            // Merge the sorted halves
            return totalComparisons + merge(arr, l, m, r);
        }
        return 0;
    }

    public static int sort(int arr[]) {
        return sort(arr, 0, arr.length-1);
    }
}
