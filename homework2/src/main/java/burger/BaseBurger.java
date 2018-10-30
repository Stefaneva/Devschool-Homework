package burger;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class BaseBurger {
    private String name;
    private Double standardBurgerPrice;
    private Double totalBurgerPrice;
    private String rollType;
    private String meatType;
    private List<Addition> additions;

    public BaseBurger(String rollType, String meatType, Double standardBurgerPrice) {
        this.rollType = rollType;
        this.meatType = meatType;
        this.standardBurgerPrice = standardBurgerPrice;
    }

    public void setAdditions(List<Addition> additions) {
        if (additions.size() <= 4)
            this.additions = additions;
        else
            System.out.println("Additions limit attained");
    }

    public Double getTotalBurgerPrice() {
        if (this.additions != null)
         return this.standardBurgerPrice + additions.stream().mapToDouble(Addition::getPrice).sum();
        return this.standardBurgerPrice;
    }

    public void addAddition(Addition addition) {
        if (this.additions == null)
            this.additions = new ArrayList<>();
        if (this.additions.size() >= 4) {
            System.out.println("Burger has full additions");
            return;
        }
        if (this.additions.stream()
                .anyMatch(addition1 -> addition1.getAdditionName().equals(addition.getAdditionName()))) {
            System.out.println("Addition already on burger");
            return;
        }
        this.additions.add(addition);
    }
}
