package ru.nsu.yadryshnikova;

import ru.nsu.yadryshnikova.collection.Pizzeria;
import ru.nsu.yadryshnikova.thread.FiniteThread;

public class PizzeriaKiller {
    public static void killPizzeria(Pizzeria pizzeria){
        pizzeria.getOrderProducer().breakWork();
        pizzeria.getCookers().forEach(FiniteThread::breakWork);
        pizzeria.getDeliveryBoys().forEach(FiniteThread::breakWork);
    }
}
