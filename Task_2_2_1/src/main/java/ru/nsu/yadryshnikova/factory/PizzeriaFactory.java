package ru.nsu.yadryshnikova.factory;

import ru.nsu.yadryshnikova.collection.Pizzeria;
import ru.nsu.yadryshnikova.delivery.DeliveryFactory;
import ru.nsu.yadryshnikova.kitchen.KitchenFactory;
import ru.nsu.yadryshnikova.producer.OrderProducer;
import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.config.PizzeriaConfiguration;
import ru.nsu.yadryshnikova.order.Order;

public class PizzeriaFactory {
    public static Pizzeria produce(PizzeriaConfiguration configuration) {
        SharedList<Order> orderSharedList = new SharedList<>(configuration.getQueueLimit());
        SharedList<Order> warehouse = new SharedList<>(configuration.getQueueLimit());
        Pizzeria pizzeria = new Pizzeria();
        var orderProducer = new OrderProducer(orderSharedList);
        pizzeria.setOrderProducer(orderProducer);

        pizzeria.setCookers(
                KitchenFactory.createCookers(
                        orderSharedList,
                        configuration.getCookConfiguration(),
                        warehouse,
                        configuration.getPizzaCookingTime()
                )
        );

        pizzeria.setDeliveryBoys(
                DeliveryFactory.createDeliveryBoys(warehouse, configuration.getDeliveryConfiguration())
        );
        orderProducer.start();
        return pizzeria;
    }
}
