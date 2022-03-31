package ru.nsu.yadryshnikova.delivery;

import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.config.PizzeriaConfiguration;
import ru.nsu.yadryshnikova.order.Order;

import java.util.ArrayList;
import java.util.List;

public class DeliveryFactory {

    public static void createDeliveryMan(
            SharedList<Order> warehouse,
            PizzeriaConfiguration.DeliveryConfiguration configuration
    ) {
        List<Integer> backpackSizes = new ArrayList<>();
        for (int i = 0; i < configuration.getNumber(); i++) {
            if (i < configuration.getNumber()) {
                backpackSizes.add(configuration.getTrunkCapacity()[i]);
            } else {
                backpackSizes.add(1);
            }
        }

        backpackSizes.forEach((it) -> {
            new DeliveryMan(warehouse, it).start();
        });
    }
}