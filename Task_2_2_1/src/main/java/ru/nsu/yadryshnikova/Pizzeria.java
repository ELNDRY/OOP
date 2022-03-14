package ru.nsu.yadryshnikova;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Pizzeria {
    
    private final Bakers bakers;
    private final DeliverymanInfo deliveryWorkers;
    private final PizzeriaStatus pizzeriaStatus;
    private final LinkedBlockingQueue<OrderInfo> waitingOrders;
    private ArrayBlockingQueue<OrderInfo> itemsInStorage;

    public Pizzeria(
            File bakerFile,
            File deliveryFile,
            ArrayBlockingQueue<OrderInfo> itemsInStorage,
            LinkedBlockingQueue<OrderInfo> waitingOrders) {
        bakers = new Bakers();
        deliveryWorkers = new DeliverymanInfo();
        pizzeriaStatus = new PizzeriaStatus();
        this.itemsInStorage = itemsInStorage;
        this.waitingOrders = waitingOrders;
        Reader reader = new Reader();
   /*     employees =
                        reader.readBakers(bakerFile),
                        reader.readDeliveryman(deliveryFile),
    */

    }

    private void order() throws InterruptedException {
        System.out.println("Order #" + pizzeriaStatus.getCurrentOrder() + ".");
        OrderInfo order = new OrderInfo(pizzeriaStatus.getCurrentOrder());
        pizzeriaStatus.newCurrentOrder();
        waitingOrders.put(order);
    }

}
