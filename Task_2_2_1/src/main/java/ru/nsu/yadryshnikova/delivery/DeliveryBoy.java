package ru.nsu.yadryshnikova.delivery;

import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.order.Order;
import ru.nsu.yadryshnikova.order.OrderStatus;
import ru.nsu.yadryshnikova.thread.FiniteThread;

import java.util.ArrayList;
import java.util.List;

public class DeliveryBoy extends FiniteThread {
    private final SharedList<Order> warehouse;
    private final Integer backpackSize;

    public DeliveryBoy(SharedList<Order> warehouse, Integer backpackSize) {
        this.warehouse = warehouse;
        this.backpackSize = backpackSize;
    }

    @Override
    public void run() {
        while (isCont()) {
            List<Order> backpack = new ArrayList<>();
            try {
                backpack = warehouse.reserveAndGet(backpackSize);
            } catch (InterruptedException e) {
                if(!isCont()){
                    break;
                }
            }
            System.out.printf("Delivery boy has left with %d orders\n", backpack.size());
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
