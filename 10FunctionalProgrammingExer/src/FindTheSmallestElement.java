import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        // приемаме списъм - > отпечатваме индексът на най - малкото число

        // 1:
//        Consumer<List<Integer>> printIndexOfMinElement = list -> {
//            int min = Collections.min(list);
//            System.out.println(list.lastIndexOf(min));
//        };
//        printIndexOfMinElement.accept(numbers);

        // 2:
        // приемаме списък и връщаме индексът на най - малкото число
        Function<List<Integer>, Integer> getIndexOf = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(getIndexOf.apply(numbers));
    }
}
