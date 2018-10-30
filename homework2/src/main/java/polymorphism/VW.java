package polymorphism;

public class VW extends Car {
    public VW(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String getName() {
        System.out.println("VW car name");
        return super.getName();
    }

    @Override
    public boolean isEngine() {
        System.out.println("VW car engine");
        return super.isEngine();
    }

    @Override
    public int getCylinders() {
        System.out.println("VW car cylinders");
        return super.getCylinders();
    }

    @Override
    public int getWheels() {
        System.out.println("VW car wheels");
        return super.getWheels();
    }
}
