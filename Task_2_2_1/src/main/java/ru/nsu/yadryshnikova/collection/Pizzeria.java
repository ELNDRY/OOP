package ru.nsu.yadryshnikova.collection;

import ru.nsu.yadryshnikova.delivery.DeliveryBoy;
import ru.nsu.yadryshnikova.kitchen.Cooker;
import ru.nsu.yadryshnikova.order.Order;
import ru.nsu.yadryshnikova.producer.OrderProducer;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    List<Cooker> cookers = new ArrayList<>();
    SharedList<Order> orderQueue;
    OrderProducer orderProducer;
    SharedList<Order> pizzaQueue;
    List<DeliveryBoy> deliveryBoys = new ArrayList<>();

    public List<Cooker> getCookers() {
        return cookers;
    }

    public void setCookers(List<Cooker> cookers) {
        this.cookers = cookers;
    }

    public SharedList<Order> getOrderQueue() {
        return orderQueue;
    }

    public void setOrderQueue(SharedList<Order> orderQueue) {
        this.orderQueue = orderQueue;
    }

    public OrderProducer getOrderProducer() {
        return orderProducer;
    }

    public void setOrderProducer(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    public SharedList<Order> getPizzaQueue() {
        return pizzaQueue;
    }

    public void setPizzaQueue(SharedList<Order> pizzaQueue) {
        this.pizzaQueue = pizzaQueue;
    }

    public List<DeliveryBoy> getDeliveryBoys() {
        return deliveryBoys;
    }

    public void setDeliveryBoys(List<DeliveryBoy> deliveryBoys) {
        this.deliveryBoys = deliveryBoys;
    }
}
