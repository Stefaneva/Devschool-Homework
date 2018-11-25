package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;

import java.util.Set;

public class PizzaFactory implements PizzaStrategy{
    @Override
    public BasePizza producePizza(String pizzaType, PizzaSauce pizzaSauce, PizzaCrust pizzaCrust, Set<PizzaExtra> pizzaExtraList) {
        if ("NeapolitanPizza".equalsIgnoreCase(pizzaType))
            return new NeapolitanPizza();
        if ("SicillianPizza".equalsIgnoreCase(pizzaType))
            return new SicillianPizza(pizzaSauce);
        if ("GreekPizza".equalsIgnoreCase(pizzaType))
            return new GreekPizza(pizzaSauce);
        if ("ItalianPizza".equalsIgnoreCase(pizzaType))
            return new ItalianPizza();
        if ("CalifornianPizza".equalsIgnoreCase(pizzaType))
            return new CalifornianPizza(pizzaCrust, pizzaSauce);
        return null;
    }
}
