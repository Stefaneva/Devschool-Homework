package burger;

import java.util.List;

public class DeluxeBurger extends BaseBurger {
    public DeluxeBurger(String rollType, String meatType, Double standardBurgerPrice) {
        super(rollType, meatType, standardBurgerPrice);
        Addition chips = new Addition("Chips", 4.2d);
        Addition drinks = new Addition("Coke", 7.2d);
        super.addAddition(chips);
        super.addAddition(drinks);
    }

    @Override
    public void setAdditions(List<Addition> additions) {
        System.out.println("Deluxe Burger can't get new additions");
    }

    @Override
    public void addAddition(Addition addition) {
        System.out.println("Deluxe Burger has no extra additions");
    }

    @Override
    public String toString() {
        return "DeluxeBurger{" +
                "name='DeluxeBurger" + '\'' +
                ", standardBurgerPrice='" + super.getStandardBurgerPrice() + '\'' +
                ", additions" + super.getAdditions() + '\'' +
                ", total burger price='" + super.getTotalBurgerPrice() + '\'' +
                "}";
    }
}
