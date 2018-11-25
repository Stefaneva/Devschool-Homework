package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;

import java.util.Set;

public class PizzaBuilderStrategy implements PizzaStrategy {

    @Override
    public BasePizza producePizza(String pizzaType, PizzaSauce pizzaSauce, PizzaCrust pizzaCrust, Set<PizzaExtra> pizzaExtras) {
        if ("NeapolitanPizza".equalsIgnoreCase(pizzaType))
            return NeapolitanPizza.builder()
                    .pizzaExtras(pizzaExtras)
                    .build();
        if ("SicillianPizza".equalsIgnoreCase(pizzaType))
            return SicillianPizza.builder()
                    .pizzaSauce(pizzaSauce)
                    .pizzaExtras(pizzaExtras)
                    .build();
        if ("GreekPizza".equalsIgnoreCase(pizzaType))
            return GreekPizza.builder()
                    .pizzaSauce(pizzaSauce)
                    .pizzaExtras(pizzaExtras)
                    .build();
        if ("ItalianPizza".equalsIgnoreCase(pizzaType))
            return ItalianPizza.builder()
                    .pizzaExtraList(pizzaExtras)
                    .build();
        if ("CalifornianPizza".equalsIgnoreCase(pizzaType))
            return CalifornianPizza.builder()
                    .pizzaCrust(pizzaCrust)
                    .pizzaSauce(pizzaSauce)
                    .pizzaExtras(pizzaExtras)
                    .build();
        return null;
    }
}
