package ru.nsu.yadryshnikova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void sortTest_orderedArray() {
        int[] expected = new int[] {1, 2, 3, 4, 5};
        // для сортировки массивов Arrays.sort (expected)
        int[] actual = expected.clone();
        HeapSort.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}