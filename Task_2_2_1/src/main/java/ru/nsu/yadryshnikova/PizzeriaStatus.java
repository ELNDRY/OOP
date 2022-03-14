package ru.nsu.yadryshnikova;

import java.util.concurrent.atomic.AtomicInteger;

public class PizzeriaStatus {
    private int currentOrder;
    private int numberOfBakers;
    private int numberOfDeliveryman;
    private int numberOfFreeBakers;
    private AtomicInteger numberOfFreeDeliveryman;

    public PizzeriaStatus() {
        currentOrder = 0;
        numberOfFreeBakers = 0;
        numberOfFreeDeliveryman = new AtomicInteger(0);
    }

    public int getCurrentOrder() {
        return currentOrder;
    }

    public void setNumberOfBakers(int number) {
        this.numberOfBakers = number;
    }

    void newCurrentOrder() {
        currentOrder++;
    }

    public void setNumberOfDeliveryman(int number) {
        this.numberOfDeliveryman = number;
    }

    void freeBaker() {
        numberOfFreeBakers++;
    }

    void freeDeliveryman() {
        numberOfFreeDeliveryman.incrementAndGet();
    }
}
