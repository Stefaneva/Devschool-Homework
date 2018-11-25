package pizzastore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public enum PizzaStore {
    PIZZASTORE;

    @Setter
    @Getter
    private List<CustomerService> customerServices;

    @Setter
    @Getter
    private List<Order> orders;

    public void addCustomerService(CustomerService customerService) {
        if (this.customerServices == null)
            this.customerServices = new ArrayList<>();
        this.customerServices.add(customerService);
    }

    public void addOrder(Order order) {
        if (this.orders == null)
            this.orders = new ArrayList<>();
        this.orders.add(order);
    }

    public void readyForDelivery(Integer orderId) {
        Order order = this.orders.stream()
                                    .filter(order1 -> order1.getOrderId()
                                    .equals(orderId))
                                    .findFirst()
                                    .orElse(null);
        if (order != null) {
            CustomerService cs = this.customerServices.stream()
                    .filter(customerService -> customerService.getCustomerServiceId()
                    .equals(order.getCustomerServiceId()))
                    .findFirst()
                    .orElse(null);
            cs.orderReadyForDelivery(order);
            this.customerServices.forEach(customerService -> {
                if (!customerService.getCustomerServiceId().equals(cs.getCustomerServiceId()))
                    customerService.orderUpdateStatus();
            });
        }
    }
}
