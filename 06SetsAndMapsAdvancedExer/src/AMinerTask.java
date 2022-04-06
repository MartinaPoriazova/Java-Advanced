import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> resourcesInfo = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            resourcesInfo.putIfAbsent(resource, 0);
            resourcesInfo.put(resource, quantity + resourcesInfo.get(resource));
            input = scanner.nextLine();
        }
        resourcesInfo.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
