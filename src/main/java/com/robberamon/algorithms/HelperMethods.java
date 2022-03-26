package com.robberamon.algorithms;

import java.util.Random;

public class HelperMethods {
    public static boolean less(Integer v, Integer w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(int[] a, int i, int j) {
        Integer t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void shuffel(int[] array) {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }
}
