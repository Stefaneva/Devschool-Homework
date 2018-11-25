package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;
import lombok.Builder;
import lombok.ToString;

import java.util.Set;

@ToString(callSuper = true)
public class CalifornianPizza extends BasePizza {
    public CalifornianPizza(PizzaCrust pizzaCrust, PizzaSauce pizzaSauce) {
        super.setPizzaCrust(pizzaCrust);
        super.setPizzaSauce(pizzaSauce);
        if (pizzaCrust == PizzaCrust.THIN)
            super.setPrice(23d);
        else if(pizzaCrust == PizzaCrust.MEDIUM)
            super.setPrice(25d);
        else if (pizzaCrust == PizzaCrust.THICK)
            super.setPrice(27d);
        else
            super.setPrice(29d);
    }

    @Builder
    public CalifornianPizza(PizzaCrust pizzaCrust, PizzaSauce pizzaSauce, Set<PizzaExtra> pizzaExtras) {
        super.setPizzaCrust(pizzaCrust);
        super.setPizzaSauce(pizzaSauce);
        if (pizzaCrust == PizzaCrust.THIN)
            super.setPrice(23d);
        else if(pizzaCrust == PizzaCrust.MEDIUM)
            super.setPrice(25d);
        else if (pizzaCrust == PizzaCrust.THICK)
            super.setPrice(27d);
        else
            super.setPrice(29d);
        super.setPizzaExtras(pizzaExtras);
    }
}
