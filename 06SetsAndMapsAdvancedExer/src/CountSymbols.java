import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (map.containsKey(currentSymbol)) {
                map.put(currentSymbol, map.get(currentSymbol) + 1);
            } else {
                map.put(currentSymbol, 1);
            }
        }

        map.forEach((key, value) -> System.out.println(key + ": " + value + " time/s"));
    }
}
