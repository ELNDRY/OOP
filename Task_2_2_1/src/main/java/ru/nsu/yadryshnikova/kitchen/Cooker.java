package ru.nsu.yadryshnikova.kitchen;

import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.order.Order;
import ru.nsu.yadryshnikova.order.OrderStatus;
import ru.nsu.yadryshnikova.thread.FiniteThread;

public class Cooker extends FiniteThread {
    private Integer workExperience;
    private SharedList<Order> ordersList;
    private Integer produceTime;
    private SharedList<Order> warehouse;

    public Cooker(Integer workExperience, SharedList<Order> ordersList, Integer produceTime, SharedList<Order> warehouse) {
        this.workExperience = workExperience;
        this.ordersList = ordersList;
        this.produceTime = produceTime;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (isCont()){
            try {
                var pizza = ordersList.get();
                pizza.setStatus(OrderStatus.COOKING);
                Thread.sleep(produceTime - workExperience);
                pizza.setStatus(OrderStatus.WAIT_DELIVERY);
                warehouse.add(pizza);
            } catch (InterruptedException ignored) {}
        }
    }
}