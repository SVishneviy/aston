package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 6, 2, 3, 9, 7, 5};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void shellSort(int[] array) {
        int size = array.length;
        for (int i = size / 2; i > 0 ; i = i / 2) {
            for (int j = i; j < size; j++) {
                int temp = array[j];
                int k;
                for (k = j; k >= i && array[k - i] > temp; k -= i) {
                    array[k] = array[k - i];
                }
                array[k] = temp;
            }
        }
    }

}