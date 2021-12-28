package ru.nsu.yadryshnikova.operations;

import java.util.List;

public class Mult implements Operation {
    @Override
    public int argsCount() {
        return 2;
    }

    @Override
    public double apply(List<Double> args) {
        return args.get(0) * args.get(1);
    }
}
