package com.robberamon;


import com.robberamon.algorithms.InsertionSort;
import com.robberamon.algorithms.SelectionSort;
import com.robberamon.helper.CustomFileWriter;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        runSelectionSort();
        runInsertionSort();
    }

    private static int[] generateRandomArray(int length) {
        Random rd = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(Math.max(length, 1000));
        }

        return arr;
    }

    private static void runSelectionSort() {
        // key: array size, value: # comparisons
        Map<Integer, Integer> comparisonsOverview = new TreeMap<>();

        for (int i = 5; i < 10000; i+=50) {
            int[] data = generateRandomArray(i);
            int comparisons = SelectionSort.sort(data);
            comparisonsOverview.put(i, comparisons);
        }

        CustomFileWriter.write(comparisonsOverview, "selectionsort");
    }

    private static void runInsertionSort() {
        // key: array size, value: # comparisons
        Map<Integer, Integer> comparisonsOverview = new TreeMap<>();

        for (int i = 5; i < 10000; i+=50) {
            int[] data = generateRandomArray(i);
            int comparisons = InsertionSort.sort(data);
            comparisonsOverview.put(i, comparisons);
        }

        CustomFileWriter.write(comparisonsOverview, "insertionsort");
    }
}
