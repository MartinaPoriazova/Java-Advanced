import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

        Consumer<String> printNames = name -> System.out.println("Sir " + name);
        // 1:
        for (String name : names) {
            printNames.accept(name);
        }
        // 2:
        Arrays.stream(names).forEach(printNames);
    }
}
