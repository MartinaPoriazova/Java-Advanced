import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersForDivision = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // ф - ция -> приема лист и число и връща т/ф
        // true -> когато числото се дели на вс числа
        // false -> не се дели на вс числа

        BiFunction<List<Integer>, Integer, Boolean> isDivisible = ((list, number) -> {
            for (int numberInList : list) {
                if (number % numberInList != 0) {
                    return false;
                }
            }
            return true;
        });
        // all nums from 1 to n
        for (int i = 1; i <= n; i++) {
            // проверка дали се дели на листа с дадени числа
            if (isDivisible.apply(numbersForDivision, i)) {
                System.out.print(i + " ");
            }
        }
    }
}
