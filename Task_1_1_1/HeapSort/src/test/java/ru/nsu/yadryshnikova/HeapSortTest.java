package ru.nsu.yadryshnikova;

import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class HeapSortTest {

    @Test
    public void testIntegerArr() {
        int[] array;
        int[] expected;
        int[] actual;

        array = new int[]{1, 2, 3, 54, 34, 2, 1, 45, 65};
        expected = array.clone();
        actual = array.clone();
        HeapSort.sort(actual);
        Arrays.sort(expected);

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    void testSortNegativeArray() {
        int[] array;
        int[] expected;
        int[] actual;
        array = new int[]{-1, -2, -3, -54, -34, -2, -1, -45, -65};
        expected = array.clone();
        actual = array.clone();
        HeapSort.sort(actual);
        Arrays.sort(expected);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSortMixedArray() {
        int[] array;
        int[] expected;
        int[] actual;
        array = new int[]{-1, -2, 3, 54, -34, -2, 1, 45, -65};
        expected = array.clone();
        actual = array.clone();
        HeapSort.sort(actual);
        Arrays.sort(expected);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testEmptyArray() {
        int[] array;
        int[] expected;
        int[] actual;
        array = new int[]{};
        expected = array.clone();
        actual = array.clone();
        HeapSort.sort(actual);
        Arrays.sort(expected);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testAnyArray() {
        int[] sizes = {100000, 200000, 400000};
        for (int n : sizes) {
            int[] array = generateRandom(n);
            int[] expected;
            int[] actual;
            expected = array.clone();
            actual = array.clone();
            HeapSort.sort(actual);
            Arrays.sort(expected);

            Assertions.assertArrayEquals(expected, actual);
        }
    }

    static int[] generateRandom(int n) {
        Random generator = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = generator.nextInt();
        return array;
    }
}



