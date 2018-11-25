import enums.PizzaCrust;
import enums.PizzaExtra;
import enums.PizzaSauce;
import pizzastore.PizzaStore;
import pizzastore.PizzaStoreFacade;

import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Set<PizzaExtra> pizzaExtraList = new HashSet<>();
        pizzaExtraList.add(PizzaExtra.PINNEAPLE);
        pizzaExtraList.add(PizzaExtra.ANCHOVIES);
        pizzaExtraList.add(PizzaExtra.BACON);
        PizzaStoreFacade pizzaStoreFacade = new PizzaStoreFacade();
        if (pizzaExtraList.size() <= 3) {
            pizzaStoreFacade.placeOrder("Neapolitan Pizza", PizzaSauce.TOMATO, PizzaCrust.EXTRATHICK, pizzaExtraList,1);
            pizzaStoreFacade.placeOrder("Californian Pizza", PizzaSauce.TOMATO, PizzaCrust.EXTRATHICK, pizzaExtraList,1);
            pizzaStoreFacade.placeOrder("Neapolitan Pizza", PizzaSauce.TOMATO, PizzaCrust.EXTRATHICK, pizzaExtraList,2);
        }
        else {
            System.out.println("You can have only 3 extras");
        }
        System.out.println(PizzaStore.PIZZASTORE);
//        pizzaStoreFacade.pizzaDone(4);
        pizzaStoreFacade.pizzaDone(2);
    }
}
