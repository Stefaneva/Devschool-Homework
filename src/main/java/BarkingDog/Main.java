package BarkingDog;

public class Main {
    public static void main(String[] args) {
        BarkingDog barkingDog = new BarkingDog();
        System.out.println(barkingDog.bark(true,1));
        System.out.println(barkingDog.bark(false, 2));
        System.out.println(barkingDog.bark(true, 8));
        System.out.println(barkingDog.bark(true, -1));
    }
}
