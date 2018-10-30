package burger;

public class HealthyBurger extends BaseBurger {
    private String healthyAddition1 = "Onion";
    private String healthyAddition2 = "Tofu";

    public HealthyBurger(String meatType, Double standardBurgerPrice) {
        super("Brown rye", meatType, standardBurgerPrice);
    }

    @Override
    public void addAddition(Addition addition) {
        if (super.getAdditions() == null || super.getAdditions().size() <= 3) {
            super.addAddition(addition);
        }
        if (!(addition.getAdditionName().equals(this.healthyAddition1) ||
                addition.getAdditionName().equals(this.healthyAddition2))) {
            System.out.println("The addition is not a healthy one, please add a healthy addition");
            return;
        }
        if (super.getAdditions().size() >=6 ) {
            System.out.println("Burger has full additions");
            return;
        }
        if (super.getAdditions().stream()
                .anyMatch(addition1 -> addition1.getAdditionName().equals(addition.getAdditionName()))) {
            System.out.println("Addition already on burger");
            return;
        }
        super.getAdditions().add(addition);
    }

    @Override
    public String toString() {
        return "HealthyBurger{" +
                "name='HealthyBurger" + '\'' +
                ", standardBurgerPrice='" + super.getStandardBurgerPrice() + '\'' +
                ", additions='" + super.getAdditions() + '\'' +
                ", total burger price='" + super.getTotalBurgerPrice() + '\'' +
                '}';
    }
}
