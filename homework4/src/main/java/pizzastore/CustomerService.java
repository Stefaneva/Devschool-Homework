package pizzastore;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pizza.BasePizza;
import pizza.PizzaBuilderStrategy;
import pizza.PizzaFactory;
import pizza.PizzaStrategy;

import java.util.ArrayList;
import java.util.Set;

@ToString
@Setter
@Getter
public class CustomerService implements OrderStatus {
    private Integer customerServiceId;

    public CustomerService(Integer customerServiceId) {
        this.customerServiceId = customerServiceId;
    }

    public void placeOrder(String pizzaType, PizzaSauce pizzaSauce, PizzaCrust pizzaCrust, Set<PizzaExtra> pizzaExtraList) {
        if (PizzaStore.PIZZASTORE.getOrders() == null)
            PizzaStore.PIZZASTORE.setOrders(new ArrayList<>());
        Order order = new Order();
        order.setOrderId(getLastOrderId() + 1);
        order.setCustomerServiceId(this.customerServiceId);
        if (pizzaExtraList == null)
            order.setPizza(getPizza(new PizzaFactory(), pizzaType, pizzaSauce, pizzaCrust, pizzaExtraList));
        else
            order.setPizza(getPizza(new PizzaBuilderStrategy(), pizzaType, pizzaSauce, pizzaCrust, pizzaExtraList));
        PizzaStore.PIZZASTORE.addOrder(order);
    }

    private static int getLastOrderId() {
        if (PizzaStore.PIZZASTORE.getOrders().size() == 0)
            return 0;
        return PizzaStore.PIZZASTORE.getOrders()
                .get(PizzaStore.PIZZASTORE.getOrders().size() - 1)
                .getOrderId();
    }

    @Override
    public void orderReadyForDelivery(Order order) {
        System.out.println("Dear customer, your order " + order + " is ready!");
    }

    @Override
    public void orderUpdateStatus() {
        System.out.println("An order has been completed, you are one step closer to receive your pizza!");
    }

    public static boolean checkPizzaType(String pizzaType) {
        return pizzaType != null && !pizzaType.equals("") && !pizzaType.isEmpty();
    }

    public BasePizza getPizza(PizzaStrategy pizzaStrategy, String pizzaType, PizzaSauce pizzaSauce,
                              PizzaCrust pizzaCrust, Set<PizzaExtra> pizzaExtras) {
        if (!checkPizzaType(pizzaType))
            return null;
        pizzaType = pizzaType.replaceAll("\\s+","");
        return pizzaStrategy.producePizza(pizzaType, pizzaSauce, pizzaCrust, pizzaExtras);
    }
}
