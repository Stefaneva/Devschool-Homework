package MinToYearsCalculator;

public class MinToYearsCalculator {
    public static void minToYearsCalculator(long minutes) {
        if (minutes < 0)
            System.out.println("Invalid Value");
        int years = (int) (minutes/(365*24*60));
        int days = (int) (minutes%525600/(24*60));
        System.out.println(minutes + " min = " + years + " y and " + days + " d");
    }
}
