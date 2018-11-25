package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;
import lombok.Builder;
import lombok.ToString;

import java.util.Set;

@ToString(callSuper = true)
public class NeapolitanPizza extends BasePizza {

    public NeapolitanPizza() {
        super.setPizzaCrust(PizzaCrust.THIN);
        super.setPizzaSauce(PizzaSauce.TOMATO);
        super.setPrice(23d);
    }

    @Builder
    public NeapolitanPizza(Set<PizzaExtra> pizzaExtras) {
        super.setPizzaCrust(PizzaCrust.THIN);
        super.setPizzaSauce(PizzaSauce.TOMATO);
        super.setPrice(23d);
        if (pizzaExtras != null) {
            super.setPrice(pizzaExtras.size() * 2.4 + super.getPrice());
        }
        super.setPizzaExtras(pizzaExtras);
    }
}
