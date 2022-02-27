package ru.nsu.yadryshnikova;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamCheckTest {

    @Test
    public void allPrimes_smallArrayPrime() {
        int[] array = new int[50];
        Arrays.fill(array, 141);
        assertTrue(new ParallelStreamCheck().allPrimes(array));
    }

    @Test
    public void allPrimes_smallArrayNotPrime() {
        int[] array = new int[50];
        Arrays.fill(array, 145);
        assertFalse(new ParallelStreamCheck().allPrimes(array));
    }

    @Test
    public void allPrimes_largeArrayPrime() {
        int[] array = new int[10000000];
        Arrays.fill(array, 1046527);
        assertTrue(new ParallelStreamCheck().allPrimes(array));
    }

    @Test
    public void allPrimes_largeArrayNotPrime() {
        int[] array = new int[10000000];
        Arrays.fill(array, 19975);
        assertFalse(new ParallelStreamCheck().allPrimes(array));
    }
}