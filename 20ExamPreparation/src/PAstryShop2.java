
import java.util.*;
import java.util.stream.Collectors;

public class PAstryShop2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);

        Map<Integer, String> foodValues = new LinkedHashMap<>();
        foodValues.put(25, "Biscuit");
        foodValues.put(50, "Cake");
        foodValues.put(75, "Pastry");
        foodValues.put(100, "Pie");

        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Biscuit", 0);
        foods.put("Cake", 0);
        foods.put("Pie", 0);
        foods.put("Pastry", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int sum = liquids.peek() + ingredients.peek();
            if (foodValues.entrySet().stream().anyMatch(e -> e.getKey() == sum)) {
                String foodCooked = foodValues.get(sum);
                foods.put(foodCooked, foods.get(foodCooked) + 1);
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                ingredients.push(ingredients.pop() + 3);
            }
        }
        if (foods.values().stream().allMatch(f -> f >= 1)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        foods.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));
    }
}
 