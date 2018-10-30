package polymorphism;

public class Audi extends Car {
    public Audi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String getName() {
        System.out.println("Audi car name");
        return super.getName();
    }

    @Override
    public boolean isEngine() {
        System.out.println("Audi car engine");
        return super.isEngine();
    }

    @Override
    public int getCylinders() {
        System.out.println("Audi car cylinders");
        return super.getCylinders();
    }

    @Override
    public int getWheels() {
        System.out.println("Audi car wheels");
        return super.getWheels();
    }
}
