package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;
import lombok.Builder;
import lombok.ToString;

import java.util.Set;

@ToString(callSuper = true)
public class SicillianPizza extends BasePizza {
    public SicillianPizza(PizzaSauce pizzaSauce) {
        super.setPizzaCrust(PizzaCrust.THICK);
        super.setPizzaSauce(pizzaSauce);
        super.setPrice(25d);
    }

    @Builder
    public SicillianPizza(PizzaSauce pizzaSauce, Set<PizzaExtra> pizzaExtras) {
        super.setPizzaCrust(PizzaCrust.THICK);
        super.setPizzaSauce(pizzaSauce);
        if (pizzaExtras != null) {
            super.setPrice(pizzaExtras.size() * 2.5 + super.getPrice());
        }
        super.setPizzaExtras(pizzaExtras);
    }
}
