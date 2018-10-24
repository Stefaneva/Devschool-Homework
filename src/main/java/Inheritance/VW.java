package Inheritance;

import java.time.ZonedDateTime;

public class VW extends Car {
    private String model;
    private ZonedDateTime yearBuilt;

    VW() {

    }

    public VW(String steering, Integer gears, Double speed, String model, ZonedDateTime yearBuilt) {
        super(steering, gears, speed);
        this.yearBuilt = yearBuilt;
        this.model = model;
    }

    public ZonedDateTime getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(ZonedDateTime yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "VW " + this.model
                + " with gear " + super.getGear()
                + ", speed " + super.getSpeed()
                + ", steering " + super.getSteering()
                + " and built in " + this.yearBuilt;
    }
}
