import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
//            for (String element:input) { - 1st way
//                elements.add(element);
//            }
//            Collections.addAll(elements, input); - 2nd way
            elements.addAll(Arrays.asList(input));
        }
        elements.forEach(element -> System.out.print(element + " "));
    }
}
