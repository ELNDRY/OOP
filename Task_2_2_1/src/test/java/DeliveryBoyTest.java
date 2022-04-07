import ru.nsu.yadryshnikova.collection.SharedList;
import ru.nsu.yadryshnikova.config.PizzeriaConfiguration;
import ru.nsu.yadryshnikova.delivery.DeliveryBoy;
import ru.nsu.yadryshnikova.delivery.DeliveryFactory;
import ru.nsu.yadryshnikova.order.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryBoyTest {

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
        var deliveryBoy = new DeliveryBoy(orders, 2);
        deliveryBoy.start();
        Thread.sleep(20);
        deliveryBoy.stop();
        Assertions.assertTrue(orders.isEmpty());
    }

    @Test
    public void deliveryNoPizzasTest() throws InterruptedException {
        SharedList<Order> orders = new SharedList<>(10);

        var deliveryConfiguration = new PizzeriaConfiguration.DeliveryConfiguration();
        deliveryConfiguration.setNumber(1);
        deliveryConfiguration.setTrunkCapacity(new Integer[]{1});

        Assertions.assertTrue(orders.isEmpty());
        var deliveryBoy = new DeliveryBoy(orders, 2);
        deliveryBoy.start();
        Thread.sleep(20);
        deliveryBoy.stop();
        Assertions.assertTrue(orders.isEmpty());
    }
}

