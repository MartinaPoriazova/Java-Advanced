import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // 2 0 3 4 9 - първо 2 и 0, после 2 и 3, после 3 и 5
        // разменя 2 и 0     // отива на следващата двойка, с отразената промяна

        // равни -> 0 -> не разменя
        // п > в -> 1 -> разменя елементите
        // п < в -> -1 -> не ги разменя

        // Първото - ляво четно, дясното нечетно
        Comparator<Integer> comparator = ((first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } // първото четно и второто четно
            // първото нечетно и второто нечетно
            else {
                return first.compareTo(second);
            }
        });
        numbers.stream().sorted(comparator).forEach(number -> System.out.print(number + " "));
    }
}
