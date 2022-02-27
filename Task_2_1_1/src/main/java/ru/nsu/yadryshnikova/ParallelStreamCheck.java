package ru.nsu.yadryshnikova;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ParallelStreamCheck extends PrimeCheck {
    @Override
    public boolean allPrimes(int[] array) {
        IntStream stream = Arrays.stream(array);
        return stream.parallel().anyMatch(number -> isNotPrime(number));
    }
}