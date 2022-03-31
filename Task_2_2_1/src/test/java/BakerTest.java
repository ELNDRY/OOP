import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.kitchen.Baker;
import ru.nsu.yadryshnikova.order.Order;
import ru.nsu.yadryshnikova.order.OrderStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BakerTest {

    @Test
    public void CookPizzaTest() throws InterruptedException {
        SharedList<Order> ordersList = new SharedList<>(10);
        SharedList<Order> warehouse = new SharedList<>(10);

        ordersList.add(new Order(1, 1));
        ordersList.add(new Order(2, 1));

        Assertions.assertFalse(ordersList.isEmpty());
        var baker = new Baker(1, ordersList, 2, warehouse);
        baker.start();
        Thread.sleep(10);
        baker.stop();
        Assertions.assertTrue(ordersList.isEmpty());

        var order = warehouse.get();
        Assertions.assertEquals(order.getId(), 1);
        Assertions.assertEquals(order.getDeliveryTime(), 1);
        Assertions.assertEquals(order.getStatus(), OrderStatus.WAIT_DELIVERY);

        order = warehouse.get();
        Assertions.assertEquals(order.getId(), 2);
        Assertions.assertEquals(order.getDeliveryTime(), 1);
        Assertions.assertEquals(order.getStatus(), OrderStatus.WAIT_DELIVERY);
    }


    @Test
    public void CookNoPizzaTest() throws InterruptedException {
        SharedList<Order> ordersList = new SharedList<>(10);
        SharedList<Order> warehouse = new SharedList<>(10);

        Assertions.assertTrue(ordersList.isEmpty());
        var baker = new Baker(1, ordersList, 2, warehouse);
        baker.start();
        Thread.sleep(10);
        baker.stop();
        Assertions.assertTrue(ordersList.isEmpty());
    }

}
