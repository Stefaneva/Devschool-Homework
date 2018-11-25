package pizza;

import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;
import lombok.Data;

import java.util.Set;

@Data
public abstract class BasePizza {
    private Double price;
    private PizzaCrust pizzaCrust;
    private PizzaSauce pizzaSauce;
    private Set<PizzaExtra> pizzaExtras;
}
