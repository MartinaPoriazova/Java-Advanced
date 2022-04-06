import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();                              // e -> Integer.parseInt(e)
        // int[] numbers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> nums = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        // 1 array - min num
        Function<int[], Integer> getMinNumber = array -> Arrays.stream(array).min().orElse(0);
//        System.out.println(getMinNumber.apply(numbers));
        Function<List<Integer>, Integer> getMinNumbers = list -> Collections.min(list); //Collections::min;
        System.out.println(getMinNumbers.apply(nums));

//        // 2 array - print min num
//        Consumer<List<Integer>> getMinNumberss = list -> System.out.println(Collections.min(list));
//        getMinNumberss.accept(nums);
//
//        // 3
//        System.out.println(Collections.min(nums));

    }
}
