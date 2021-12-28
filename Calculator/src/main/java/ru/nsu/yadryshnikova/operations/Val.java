package ru.nsu.yadryshnikova.operations;

import java.util.List;

public class Val implements Operation {

    private double value;

    public Val(double value) {
        this.value = value;
    }

    @Override
    public int argsCount() {
        return 0;
    }

    @Override
    public double apply(List<Double> args) {
        return value;
    }
}
