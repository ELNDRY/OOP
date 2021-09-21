package ru.nsu.yadryshnikova;

import java.util.Scanner;

public class HeapSort {

    public static void sort(int[] array) {
        /* build a heap */
        int length = array.length ;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, i);
        }

        /* One by one extract an element from the heap
         * and move the largest root to the end */
        for (int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            /* heapify the affected subtree */
            heapify(array, 0);
        }
    }

    /* create Max Heap Binary Tree array
     * where Maximum item on first position or root. */
    public static void heapify(int[] array, int i) {
        int min = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        /* If left child is larger than root */
        if (left < array.length && array[left] < array[min])
            min = left;

        /* If left child is larger than current largest */
        if (right < array.length && array[right] < array[min])
            min = right;

        if (min != i) {
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;

            /* Recursively heapify the subtree */
            heapify(array, min);
        }
    }

    public static void printArray(int[] array) {
        for (int i : array)
            System.out.println(i + " ");
    }
}
