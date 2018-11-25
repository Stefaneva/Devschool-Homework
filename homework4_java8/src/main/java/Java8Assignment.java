import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Assignment {
    public static void main(String[] args) {
        /**
         * Given the following input data.
         */
        List<Integer> numbers = IntStream.range(0, 1_000)
                .boxed()
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("One", "Two", "three", "four", "five", "six", "seven", "Eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "Fourteen", "fifteen", "sixteen", "Nineteen", "twenty");

        /**
         * Implement ONE method PER exercise given todos:
         */

        /**
         * For each
         */
        // 1: using "numbers" as input, print first ten numbers
//        example(numbers);
        // 2: using "numbers" as input print first ten odd numbers
        // 3: using "numbers" as input print first ten even numbers
        // 4: implement 1, 2, 3 using one method

        /**
         * Sums
         */
        // 5. using "numbers" as input print their sum
        // 6. using "numbers" as input print the sum of the odd numbers
        // 7. using "numbers" as input print the sum of the even numbers
        // 8. using "numbers" as input print the sum of the even numbers which contain '7'
        // 9. implement 5, 6, 7, 8 using one method

        /**
         * Mixed map/filter/reduce
         */
        // 10. using "numbers" calculate the sum of the double of even numbers
        // 11. using "numbers" calculate the sum of the triple of odd numbers
        // 12. using "numbers" calculate the sum of their half (1/2)
        // 13 implement 10, 11, 12 using one method

        /**
         * Collectors
         */
        // 14. using "words" as input print a string with each UPPERCASED word separated by ', '
        // 15. using "words" as input create a List containing all words starting with a vowel
        // 16. using "words" as input create a List containing all words ending in 'teen'
        // 17. implement 11 and 12 using one method
        // 18. using words as input create a Set of words with an odd number of letters
        // 19. using words as input create a Set containing the number of letters in a word

        /**
         * Converting to java 8
         */
        // 20. convert the following code to java 8
        /**
         * Optional<T>
         */
        // 21. using "numbers" as input print the first odd number that can be divided by 121, if it does not exist print -1

        // Methods
//        forEach1(numbers);
//        forEach2(numbers);
//        forEach3(numbers);
//        forEach4(numbers,i-> i%2 == 0, 20);
//        sums1(numbers);
//        sums2(numbers);
//        sums3(numbers);
//        sums4(numbers);
//        sums5(numbers,i -> String.valueOf(i).contains("7"));
//        mixed1(numbers);
//        mixed2(numbers);
//        mixed3(numbers);
//        mixed4(numbers, i -> i%2 == 0, i-> i*2d);
//        collectors1(words);
//        collectors2(words);
//        collectors123(words, word -> word.toLowerCase().endsWith("teen"));
//        collectors4(words);
//        collectors5(words);
        nonJava8Method(numbers);
        java8Method(numbers);
        optional(numbers);
    }

    public static void forEach1(List<Integer> numbers) {
        numbers.stream().limit(10).forEach(System.out::println);
    }

    public static void forEach2(List<Integer> numbers) {
        numbers.stream().limit(20).filter(i -> i%2 == 1).forEach(System.out::println);
    }

    public static void forEach3(List<Integer> numbers) {
        numbers.stream().limit(20).filter(i -> i%2 == 0).forEach(System.out::println);
    }

    public static void forEach4(List<Integer> numbers,
                                Predicate<Integer> predicate,
                                Integer limit) {
        numbers.stream().limit(limit).filter(predicate).forEach(System.out::println);
    }

    public static void sums1(List<Integer> numbers) {
        System.out.println(numbers.stream().reduce((acc,number) -> acc+=number).get());
    }

    public static void sums2(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(i -> i%2 == 1).reduce((acc,number)-> acc+=number).get());
    }

    public static void sums3(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(i -> i%2 == 0).reduce((acc,number)-> acc+=number).get());
    }

    public static void sums4(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(i -> String.valueOf(i).contains("7")).reduce((acc,number)-> acc+=number).get());
    }

    public static void sums5(List<Integer> numbers,
                            Predicate<Integer> predicate) {
        System.out.println(numbers.stream().filter(predicate).reduce((acc,number) -> acc+=number).get());
    }

    public static void mixed1(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(i -> i%2 == 0).mapToInt(i-> i*2).sum());
    }

    public static void mixed2(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(i -> i%2 == 1).mapToInt(i -> i*3).sum());
    }

    public static void mixed3(List<Integer> numbers) {
        System.out.println(numbers.stream().mapToDouble(i -> i/2d).sum());
    }

    public static void mixed4(List<Integer> numbers,
                              Predicate<Integer> predicate,
                              Function<Integer, Double> function) {
        System.out.println(numbers.stream().filter(predicate).map(function).reduce((acc,number) -> acc+number).get());
    }

    public static void collectors1(List<String> words) {
        System.out.println(words.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }

    public static void collectors2(List<String> words) {
        System.out.println(words.stream().filter(word -> word.substring(0,1).matches("[AEIOUaeiou]")).collect(Collectors.toList()));
    }

    public static void collectors3(List<String> words) {
        System.out.println(words.stream().filter(word -> word.toLowerCase().endsWith("teen")).collect(Collectors.toList()));
    }

    public static void collectors123(List<String> words,
                                     Predicate<String> predicate) {
        System.out.println(words.stream().filter(predicate).collect(Collectors.toList()));
    }

    public static void collectors4(List<String> words) {
        System.out.println(words.stream().filter(word -> word.length() %2 == 1).collect(Collectors.toSet()));
    }

    public static Function<String, String> numberOfLetters() {
        return s -> {
          Integer x = s.length();
          return x.toString();
        };
    }

    public static void collectors5(List<String> words) {
        System.out.println(words.stream().map(numberOfLetters()).collect(Collectors.toSet()));
    }

    private static void example(List<Integer> numbers) {
        numbers.stream()
                .limit(10)
                .forEach(System.out::print);
    }

    public static Function<Integer, Integer> helperFunctionJava8() {
        return y -> {
          if (y % 20 == 3)
              y = y/20;
          return y/10;
        };
    }

    private static void java8Method(List<Integer> numbers) {
        System.out.println(numbers
                            .stream()
                            .limit(11)
                            .filter(i -> i%2 == 0)
                            .map(i -> (i+5) * 7)
                            .map(helperFunctionJava8())
                            .reduce((acc,i) -> acc+=i)
                            .get());
    }

    private static void nonJava8Method(List<Integer> numbers) {
        int sum = 0;
        int counter = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int num = 0;

            if (numbers.get(i) % 2 == 0) {
                num = numbers.get(i) + 5;
            } else {
                sum += 0;
                continue;
            }
            num = num * 7;
            if (num % 20 == 3) {
                num = num / 20;
            }

            sum += (num / 10);

            if (++counter > 5) {
                break;
            }
        }

        System.out.println(sum);
    }

    private static void optional(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(i -> i % 121 == 0 && i % 2 == 1).findFirst().orElse(-1));
//        System.out.println(numbers.stream().limit(10).filter(i -> i % 121 ==0 && i != 0).findFirst().orElse(-1));
    }
}