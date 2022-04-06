import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // first - queue - bucket
        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsQueue::offer);

        // last - stack - freshness
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(freshnessStack::push);
        Map<Integer, String> cocktails = new TreeMap<>();
        cocktails.put(150, "Pear Sour");
        cocktails.put(250, "The Harvest");
        cocktails.put(300, "Apple Hinny");
        cocktails.put(400, "High Fashion");

        Map<String, Integer> cocktailsCount = new TreeMap<>();
        cocktailsCount.put("Pear Sour", 0);
        cocktailsCount.put("The Harvest", 0);
        cocktailsCount.put("Apple Hinny", 0);
        cocktailsCount.put("High Fashion", 0);

        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int ingredientTOCeck = ingredientsQueue.peek();
            if (ingredientTOCeck == 0) {
                ingredientsQueue.poll();
                continue;
            }
            int mixResult = ingredientsQueue.peek() * freshnessStack.peek();

            if (cocktails.entrySet().stream().anyMatch(e -> e.getKey() == mixResult)) {
                String mixedCocktail = cocktails.get(mixResult);
                cocktailsCount.put(mixedCocktail, cocktailsCount.get(mixedCocktail) + 1);
                ingredientsQueue.poll();
                freshnessStack.pop();
            } else {
                freshnessStack.pop();
                ingredientsQueue.offer(ingredientsQueue.poll() + 5);
                ingredientsQueue.push(ingredientsQueue.poll());


            }
        }
        if (cocktailsCount.values().stream().allMatch(f -> f >= 1)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredientsQueue.isEmpty()) {
            int sumIngredientsQueue = 0;
            for (int ingredient : ingredientsQueue) {
                sumIngredientsQueue += ingredient;
            }
            System.out.println("Ingredients left: " + sumIngredientsQueue);
        }
        // " # {cocktail name} --> {amount}".
        cocktailsCount.forEach((key, value) -> {
            if (value > 0) {
                System.out.printf(" # %s --> %d\n", key, value);
            }
        });
    }
}

