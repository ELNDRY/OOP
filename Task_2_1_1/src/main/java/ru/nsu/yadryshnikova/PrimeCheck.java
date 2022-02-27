package ru.nsu.yadryshnikova;

public class PrimeCheck {
    public boolean isNotPrime(int number) {
        if (number <= 1) {
            return true;
        }
        if (number == 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean allPrimes(int[] array) {
        for(int i : array) {
            if(isNotPrime(i)) {
                return false;
            }
        }
        return true;
    }
}
