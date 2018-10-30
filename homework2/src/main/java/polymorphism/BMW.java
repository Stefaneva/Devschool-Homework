package polymorphism;

public class BMW extends Car {
    public BMW(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String getName() {
        System.out.println("BMW car name");
        return super.getName();
    }

    @Override
    public boolean isEngine() {
        System.out.println("BMW car engine");
        return super.isEngine();
    }

    @Override
    public int getCylinders() {
        System.out.println("BMW car cylinders");
        return super.getCylinders();
    }

    @Override
    public int getWheels() {
        System.out.println("BMW car wheels");
        return super.getWheels();
    }
}
