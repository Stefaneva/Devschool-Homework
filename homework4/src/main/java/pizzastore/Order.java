package pizzastore;

import lombok.Data;
import lombok.ToString;
import pizza.BasePizza;

@Data
@ToString
public class Order {
    private Integer orderId;
    private Integer customerServiceId;
    private BasePizza pizza;
}
