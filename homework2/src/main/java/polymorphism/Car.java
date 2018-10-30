package polymorphism;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
    }

    public String getName() {
        System.out.println("Generic car name is " + this.name);
        return name;
    }

    public boolean isEngine() {
        System.out.println("Generic car engine is " + this.engine);
        return engine;
    }

    public int getCylinders() {
        System.out.println("Generic car cylinders are " + this.cylinders);
        return cylinders;
    }

    public int getWheels() {
        System.out.println("Generic car wheels are " + this.wheels);
        return wheels;
    }
}
