package ru.nsu.yadryshnikova.delivery;

import ru.nsu.yadryshnikova.collection.SharedList;
import lombok.AllArgsConstructor;
import ru.nsu.yadryshnikova.order.Order;
import ru.nsu.yadryshnikova.order.OrderStatus;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class DeliveryMan extends Thread {
    private final SharedList<Order> warehouse;
    private final Integer backpackSize;

    @Override
    public void run() {
        while (true) {
            List<Order> backpack;
            try {
                backpack = warehouse.reserveAndGet(backpackSize);
            } catch (InterruptedException ignored) {
                continue;
            }

            for (int i = 0; i < backpackSize; i++) {
                try {
                    var order = warehouse.get();
                    backpack.add(order);
                    order.setStatus(OrderStatus.DELIVERING);
                } catch (InterruptedException ignored) {
                }
            }
            backpack.forEach((it) -> {
                try {
                    Thread.sleep(it.getDeliveryTime());
                } catch (InterruptedException ignored) {
                }
                it.setStatus(OrderStatus.DELIVERED);
            });
        }
    }
}
