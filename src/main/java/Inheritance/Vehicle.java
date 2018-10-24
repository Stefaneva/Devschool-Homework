package Inheritance;

public class Vehicle {
    private String steering;

    Vehicle() {

    }

    Vehicle(String steering) {
        this.steering = steering;
    }

    public String getSteering() {
        return steering;
    }

    public void setSteering(String steering) {
        this.steering = steering;
    }
}
