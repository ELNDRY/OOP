package ru.nsu.yadryshnikova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.yadryshnikova.PrimeCheck;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PrimeCheckTest {

    @Test
    void isNotPrime_negative() {
        Assertions.assertTrue(new PrimeCheck().isNotPrime(-14));
    }
    @Test
    void isNotPrime_prime() {
        Assertions.assertFalse(new PrimeCheck().isNotPrime(83));
    }

    @Test
    void isNotPrime_primeLarge() {
        assertFalse(new PrimeCheck().isNotPrime(1073676287));
    }

    @Test
    void isNotPrime_notPrimeLarge() {
        assertTrue(new PrimeCheck().isNotPrime(1073676284));
    }

    @Test
    void allPrimes_largeArrayTrue() {
        int size = 1000000;
        int[] array = new int[size];
        Arrays.fill(array, 361275);
        assertTrue(new PrimeCheck().allPrimes(array));
    }

    @Test
    void allPrimes_largeArrayFalse() {
        int size = 1000000;
        int[] array = new int[size];
        Arrays.fill(array, 361272);
        assertFalse(new PrimeCheck().allPrimes(array));
    }

}