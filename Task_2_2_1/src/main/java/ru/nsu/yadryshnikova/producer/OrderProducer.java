package ru.nsu.yadryshnikova.producer;

import ru.nsu.yadryshnikova.collection.SharedList;
import lombok.AllArgsConstructor;
import ru.nsu.yadryshnikova.order.Order;

@AllArgsConstructor
public class OrderProducer extends Thread {
    private final SharedList<Order> list;

    @Override
    public void run() {
        int id = 0;
        while (true) {
            try {
                Thread.sleep((long) (50 * Math.random()));
            } catch (InterruptedException e) {
                if (this.isAlive()) {
                    continue;
                }
            }
            try {
                list.add(new Order(id++, (int) (50 * Math.random())));
            } catch (InterruptedException ignored) {
            }
        }
    }
}