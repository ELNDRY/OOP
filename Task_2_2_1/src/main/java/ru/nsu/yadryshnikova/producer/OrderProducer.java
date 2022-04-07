package ru.nsu.yadryshnikova.producer;

import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.order.Order;
import ru.nsu.yadryshnikova.thread.FiniteThread;

public class OrderProducer extends FiniteThread {
    private final SharedList<Order> list;

    public OrderProducer(SharedList<Order> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int id = 0;
        while (this.isCont()) {
            try {
                Thread.sleep((long) (50 * Math.random()));
                list.add(new Order(id++, (int) (50 * Math.random())));
            } catch (InterruptedException ignored) {
                if(isCont()){
                    break;
                }
            }
        }
    }
}
