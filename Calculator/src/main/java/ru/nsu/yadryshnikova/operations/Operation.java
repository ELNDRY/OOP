package ru.nsu.yadryshnikova.operations;

import java.util.List;

public interface Operation {
    int argsCount();
    double apply(List<Double> args);
}
