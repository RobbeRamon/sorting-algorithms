package com.robberamon;


import com.robberamon.algorithms.InsertionSort;
import com.robberamon.algorithms.MergeSort;
import com.robberamon.algorithms.QuickSort;
import com.robberamon.algorithms.SelectionSort;
import com.robberamon.helper.CustomFileWriter;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //runSelectionSort();
        //runInsertionSort();
        //runInsertionSortForSpread();
        runInsertionSortForSpread(50);
        //runMergeSort();
        //runQuickSort();
        //smallRunQuickSort();
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

    private static void runInsertionSortForSpread() {
        for (int j = 0; j < 15; j++) {
            // key: array size, value: # comparisons
            Map<Integer, Integer> comparisonsOverview = new TreeMap<>();

            for (int i = 5; i < 10000; i+=50) {
                int[] data = generateRandomArray(10000);
                int comparisons = InsertionSort.sort(data);
                comparisonsOverview.put(i, comparisons);
            }

            String filename = "insertionsort-" + j;

            CustomFileWriter.write(comparisonsOverview, filename);
        }
    }

    private static void runInsertionSortForSpread(int size) {
        List<Integer> comparisonsList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int[] data = generateRandomArray(size);
            int comparisons = InsertionSort.sort(data);
            comparisonsList.add(comparisons);
        }

        CustomFileWriter.write(comparisonsList, "insertionsort-spread");
    }

    private static void runInsertionSort() {
        // key: array size, value: # comparisons
        Map<Integer, Integer> comparisonsOverview = new TreeMap<>();

        for (int i = 5; i < 10000; i+=50) {
            List<Integer> allComparisons = new ArrayList<>();

            for (int j = 0; j < 15; j++) {
                int[] data = generateRandomArray(i);
                int comparisons = InsertionSort.sort(data);
                allComparisons.add(comparisons);
            }

            int comparisonsMean = (int)allComparisons
                    .stream()
                    .mapToDouble(d -> d)
                    .average()
                    .orElse(0.0);

            comparisonsOverview.put(i, comparisonsMean);
        }

        String filename = "insertionsort";

        CustomFileWriter.write(comparisonsOverview, filename);
    }

    private static void runMergeSort() {
        // key: array size, value: # comparisons
        Map<Integer, Integer> comparisonsOverview = new TreeMap<>();

        for (int i = 5; i < 10000; i+=50) {
            List<Integer> allComparisons = new ArrayList<>();

            for (int j = 0; j < 100; j++) {
                int[] data = generateRandomArray(i);
                int comparisons = MergeSort.sort(data);
                allComparisons.add(comparisons);
            }

            int comparisonsMean = (int)allComparisons
                    .stream()
                    .mapToDouble(d -> d)
                    .average()
                    .orElse(0.0);

            comparisonsOverview.put(i, comparisonsMean);
        }

        String filename = "mergesort";

        CustomFileWriter.write(comparisonsOverview, filename);
    }

    private static void smallRunQuickSort() {
        // key: array size, value: # comparisons
        Map<Integer, Integer> comparisonsOverview = new TreeMap<>();

        int[] data = generateRandomArray(50);
        int comparisons = QuickSort.sort(data);
        System.out.println(comparisons);
        System.out.println(Arrays.toString(data));
    }

    private static void runQuickSort() {
        // key: array size, value: # comparisons
        Map<Integer, Integer> comparisonsOverview = new TreeMap<>();

        for (int i = 5; i < 10000; i+=50) {
            List<Integer> allComparisons = new ArrayList<>();

            for (int j = 0; j < 100; j++) {
                int[] data = generateRandomArray(i);
                int comparisons = QuickSort.sort(data);
                allComparisons.add(comparisons);
            }

            int comparisonsMean = (int)allComparisons
                    .stream()
                    .mapToDouble(d -> d)
                    .average()
                    .orElse(0.0);

            comparisonsOverview.put(i, comparisonsMean);
        }

        String filename = "quicksort";

        CustomFileWriter.write(comparisonsOverview, filename);

    }
}
