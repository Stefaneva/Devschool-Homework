package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;
import lombok.Builder;
import lombok.ToString;

import java.util.Set;

@ToString(callSuper = true)
public class GreekPizza extends BasePizza {
    public GreekPizza(PizzaSauce pizzaSauce) {
        super.setPizzaCrust(PizzaCrust.THICK);
        super.setPizzaSauce(pizzaSauce);
        super.setPrice(28d);
    }

    @Builder
    public GreekPizza(PizzaSauce pizzaSauce, Set<PizzaExtra> pizzaExtras) {
        super.setPizzaCrust(PizzaCrust.THICK);
        super.setPizzaSauce(pizzaSauce);
        super.setPrice(28d);
        if (pizzaExtras != null) {
            super.setPrice(pizzaExtras.size() * 3.0 + super.getPrice());
        }
        super.setPizzaExtras(pizzaExtras);
    }
}
