package polymorphism;

public class Main {
    public static void main(String[] args) {
        Car bmw = new BMW(5,"BMW");
        Car audi = new Audi(3, "Audi");
        Car vw = new VW(4,"Golf");
        System.out.println(bmw.getName());
        System.out.println(audi.isEngine());
        System.out.println(vw.getCylinders());
    }
}
