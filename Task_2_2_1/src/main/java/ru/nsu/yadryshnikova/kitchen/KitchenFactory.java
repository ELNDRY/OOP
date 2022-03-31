package ru.nsu.yadryshnikova.kitchen;

import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.config.PizzeriaConfiguration;
import ru.nsu.yadryshnikova.order.Order;

import java.util.ArrayList;
import java.util.List;

public class KitchenFactory {
    public static void createCookers(
            SharedList<Order> queueForKitchen,
            PizzeriaConfiguration.CookConfiguration configuration,
            SharedList<Order> queueForWarehouse,
            Integer cokingTime
    ) {
        List<Integer> exp = new ArrayList<>();
        for (int i = 0; i < configuration.getNumber(); i++) {
            if (i < configuration.getExperience().length) {
                exp.add(configuration.getExperience()[i]);
            } else {
                exp.add(0);
            }
        }
        exp.forEach((it) -> new Baker(it, queueForKitchen, cokingTime, queueForWarehouse).start());
    }
}
