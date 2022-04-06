import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // first - liquids - from the first
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquidsQueue::offer);
        // second - ingredients - from last
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsStack::push);
        Map<Integer, String> food = new TreeMap<>();
        food.put(25, "Bread");
        food.put(50, "Cake");
        food.put(75, "Pastry");
        food.put(100, "Fruit Pie");
        Map<String, Integer> cookedFoods = new TreeMap<>();
        cookedFoods.put("Bread", 0);
        cookedFoods.put("Cake", 0);
        cookedFoods.put("Pastry", 0);
        cookedFoods.put("Fruit Pie", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int sum = liquidsQueue.peek() + ingredientsStack.peek();
            if (food.entrySet().stream().anyMatch(e->e.getKey() == sum)) {
                String foodCooked = food.get(sum);
                cookedFoods.put(foodCooked, cookedFoods.get(foodCooked) + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);
            }
        }
        if (cookedFoods.values().stream().allMatch(f -> f >= 1)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        cookedFoods.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }
}
