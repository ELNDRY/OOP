package ru.nsu.yadryshnikova.kitchen;

import ru.nsu.yadryshnikova.collection.SharedList;
import lombok.AllArgsConstructor;
import ru.nsu.yadryshnikova.order.Order;
import ru.nsu.yadryshnikova.order.OrderStatus;

@AllArgsConstructor
public class Baker extends Thread {
    private Integer workExperience;
    private SharedList<Order> ordersList;
    private Integer produceTime;
    private SharedList<Order> warehouse;

    @Override
    public void run() {
        while (true){
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