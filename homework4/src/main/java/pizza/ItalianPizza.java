package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;
import lombok.Builder;
import lombok.ToString;

import java.util.Set;

@ToString(callSuper = true)
public class ItalianPizza extends BasePizza {
    public ItalianPizza() {
        super.setPizzaCrust(PizzaCrust.EXTRATHICK);
        super.setPizzaSauce(PizzaSauce.TOMATO);
        super.setPrice(31d);
    }

    @Builder
    public ItalianPizza(Set<PizzaExtra> pizzaExtraList) {
        super.setPizzaCrust(PizzaCrust.EXTRATHICK);
        super.setPizzaSauce(PizzaSauce.TOMATO);
        super.setPrice(31d);
        super.setPizzaExtras(pizzaExtraList);
    }
}
