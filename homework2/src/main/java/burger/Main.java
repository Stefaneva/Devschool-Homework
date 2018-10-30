package burger;

import javax.management.BadAttributeValueExpException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BaseBurger baseBurger = new BaseBurger("Plain","Beef", 11.99d);
        baseBurger.setName("Classic Burger");
        List<Addition> additionList = new ArrayList<>();
        additionList.add(new Addition("Lettuce", 2.3d));
        additionList.add(new Addition("Carrot", 1.5d));
        additionList.add(new Addition("Tomato", 2.0d));
//        additionList.add(new Addition("Tomato", 2.0d));
        additionList.add(new Addition("Mayonnaise", 3.2d));
        baseBurger.setAdditions(additionList);
        System.out.println(baseBurger);

        BaseBurger healthyBurger = new HealthyBurger("Chicken", 14.5d);
        healthyBurger.setAdditions(additionList);
        healthyBurger.addAddition(new Addition("Onion", 2.0d));
        healthyBurger.addAddition(new Addition("Mayonnaise", 3.2d));
        healthyBurger.addAddition(new Addition("Tofu", 3.2d));
        System.out.println(healthyBurger);

        BaseBurger deluxeBurger = new DeluxeBurger("Sesame seed", "Bacon", 13.89);
        deluxeBurger.addAddition(new Addition("Lettuce", 2.3d));
        System.out.println(deluxeBurger);
    }
}
