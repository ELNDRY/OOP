package ru.nsu.yadryshnikova.factory;

import ru.nsu.yadryshnikova.delivery.DeliveryFactory;
import ru.nsu.yadryshnikova.kitchen.KitchenFactory;
import ru.nsu.yadryshnikova.producer.OrderProducer;
import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.config.PizzeriaConfiguration;
import ru.nsu.yadryshnikova.order.Order;

public class PizzeriaFactory {
    public static void produce(PizzeriaConfiguration configuration) {
        SharedList<Order> orderSharedList = new SharedList<>(configuration.getQueueLimit());
        SharedList<Order> warehouse = new SharedList<>(configuration.getQueueLimit());
        var orderProducer = new OrderProducer(orderSharedList);

        KitchenFactory.createCookers(
                orderSharedList,
                configuration.getCookConfiguration(),
                warehouse,
                configuration.getPizzaCookingTime()
        );

        DeliveryFactory.createDeliveryMan(warehouse, configuration.getDeliveryConfiguration());

        orderProducer.start();
    }
}
