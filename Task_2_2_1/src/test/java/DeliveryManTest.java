import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.config.PizzeriaConfiguration;
import ru.nsu.yadryshnikova.delivery.DeliveryMan;
import ru.nsu.yadryshnikova.order.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryManTest {

    @Test
    public void deliverSomePizzasTest() throws InterruptedException {
        SharedList<Order> orders = new SharedList<>(10);
        orders.add(new Order(1, 1));
        orders.add(new Order(2, 1));
        orders.add(new Order(3, 1));

        var deliveryConfiguration = new PizzeriaConfiguration.DeliveryConfiguration();
        deliveryConfiguration.setNumber(1);
        deliveryConfiguration.setTrunkCapacity(new Integer[]{1});

        Assertions.assertFalse(orders.isEmpty());
        var deliveryMan = new DeliveryMan(orders, 2);
        deliveryMan.start();
        Thread.sleep(20);
        deliveryMan.stop();
        Assertions.assertTrue(orders.isEmpty());
    }

    @Test
    public void deliveryNoPizzasTest() throws InterruptedException {
        SharedList<Order> orders = new SharedList<>(10);

        var deliveryConfiguration = new PizzeriaConfiguration.DeliveryConfiguration();
        deliveryConfiguration.setNumber(1);
        deliveryConfiguration.setTrunkCapacity(new Integer[]{1});

        Assertions.assertTrue(orders.isEmpty());
        var deliveryMan = new DeliveryMan(orders, 2);
        deliveryMan.start();
        Thread.sleep(20);
        deliveryMan.stop();
        Assertions.assertTrue(orders.isEmpty());
    }

}