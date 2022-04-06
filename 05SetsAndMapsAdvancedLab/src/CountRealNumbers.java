import java.util.*;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> map = new LinkedHashMap<>();
        double currentNumber = 0;
        int counter = 1;

        for (double number : numbers) {
            currentNumber = number;

            if (map.containsKey(currentNumber)) {
                map.put(currentNumber, map.get(currentNumber) + 1);
            } else {
                map.put(currentNumber, counter);
            }

        }

        map.forEach((key, value) -> {
            System.out.printf("%.1f -> %d\n", key, value);
        });

    }
}
