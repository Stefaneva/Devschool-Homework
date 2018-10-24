package Inheritance;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        VW vehicle = new VW("Right",6,0.0, "Golf", ZonedDateTime.now());
        vehicle.setYearBuilt(ZonedDateTime.of(LocalDateTime.of(2015,Month.APRIL,25,10,5), ZoneId.of("CET")));
        vehicle.setGear(7);
        vehicle.setGear(5);
        vehicle.increaseSpeed(80D);
        vehicle.increaseSpeed(700D);
        vehicle.decreaseSpeed(20D);
        System.out.println(vehicle);
    }
}
