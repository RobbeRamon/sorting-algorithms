package com.robberamon;


import com.robberamon.helper.CustomFileWriter;
import main.java.com.robberamon.algorithms.SelectionSort;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // key: array size, value: # comparisons
        Map<Integer, Integer> comparisonsOverview = new TreeMap<>();

        for (int i = 5; i < 10000; i+=50) {
            int[] data = generateRandomArray(i);
            int comparisons = SelectionSort.sort(data);
            comparisonsOverview.put(i, comparisons);
        }

        System.out.println(comparisonsOverview);
        CustomFileWriter.write(comparisonsOverview, "selectionsort");
    }

    public static int[] generateRandomArray(int length) {
        Random rd = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(Math.max(length, 1000));
        }

        return arr;
    }
}
