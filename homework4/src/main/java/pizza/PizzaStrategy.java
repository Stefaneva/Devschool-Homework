package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;

import java.util.Set;

public interface PizzaStrategy {
    BasePizza producePizza(String pizzaType, PizzaSauce pizzaSauce, PizzaCrust pizzaCrust, Set<PizzaExtra> pizzaExtraList);
}
