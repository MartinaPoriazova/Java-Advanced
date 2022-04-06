import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        // преобръщаме на обратно списъка
        Collections.reverse(numbers);
        // премахваме вс числа, които се делят на n
        // искам да приема число - true or false  проверка
        Predicate<Integer> checkDivision = number -> number % n == 0;
        numbers.removeIf(checkDivision); // - премахни го, ако предикатът е равен на тру

        numbers.forEach(e -> System.out.print(e + " "));

    }
}
