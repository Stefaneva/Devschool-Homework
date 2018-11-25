package pizzastore;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;

import java.util.ArrayList;
import java.util.Set;

public class PizzaStoreFacade {

    public void placeOrder(String pizzaType, PizzaSauce pizzaSauce, PizzaCrust pizzaCrust, Set<PizzaExtra> pizzaExtraList, Integer customerId) {
        PizzaStore pizzaStore = PizzaStore.PIZZASTORE;
        CustomerService customerService;
        if (pizzaStore.getCustomerServices() == null)
            pizzaStore.setCustomerServices(new ArrayList<>());
        customerService = pizzaStore.getCustomerServices()
                                        .stream()
                                        .filter(service -> service.getCustomerServiceId().equals(customerId))
                                        .findFirst()
                                        .orElse(null);
        if (customerService == null)
            customerService = new CustomerService(customerId);
        pizzaStore.addCustomerService(customerService);
        customerService.placeOrder(pizzaType, pizzaSauce, pizzaCrust, pizzaExtraList);
        System.out.println("Dear customer, your order has been placed!");
    }

    public void pizzaDone(Integer orderId) {
        PizzaStore.PIZZASTORE.readyForDelivery(orderId);
    }
}
