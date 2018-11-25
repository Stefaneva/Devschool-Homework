package pizzastore;

public interface OrderStatus {
    void orderReadyForDelivery(Order order);
    void orderUpdateStatus();
}
