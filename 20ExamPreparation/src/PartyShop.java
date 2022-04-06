import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PartyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> liquids = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> ingredients = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        the first liquid and try to mix it with the last ingredient
        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Biscuit", 25);
        foods.put("Cake", 50);
        foods.put("Pie", 75);
        foods.put("Pastry", 100);

        Map<String, Integer> cookedFoods = new LinkedHashMap<>();

        for (int i = 0; i < liquids.size(); i++) {
            for (int j = ingredients.size() - 1; j >= 0; j--) {

                if (liquids.get(i) + ingredients.get(j) == 25) {
                    liquids.remove(i);
                    ingredients.remove(j);
                    if (!cookedFoods.containsKey("Biscuit")) {
                        cookedFoods.put("Biscuit", 1);
                    } else {
                        cookedFoods.put("Biscuit", cookedFoods.get("Biscuit") + 1);
                    }

                } else if (liquids.get(i) + ingredients.get(j) == 50) {
                    liquids.remove(i);
                    ingredients.remove(j);
                    if (!cookedFoods.containsKey("Cake")) {
                        cookedFoods.put("Cake", 1);
                    } else {
                        cookedFoods.put("Cake", cookedFoods.get("Cake") + 1);
                    }

                } else if (liquids.get(i) + ingredients.get(j) == 100) {
                    liquids.remove(i);
                    ingredients.remove(j);
                    if (!cookedFoods.containsKey("Pie")) {
                        cookedFoods.put("Pie", 1);
                    } else {
                        cookedFoods.put("Pie", cookedFoods.get("Pie") + 1);
                    }
                } else if (liquids.get(i) + ingredients.get(j) == 75) {
                    liquids.remove(i);
                    ingredients.remove(j);
                    if (!cookedFoods.containsKey("Pastry")) {
                        cookedFoods.put("Pastry", 1);
                    } else {
                        cookedFoods.put("Pastry", cookedFoods.get("Pastry") + 1);
                    }
                } else {
                    liquids.remove(i);
                    ingredients.set(j, ingredients.get(j) + 3);

                }
                if (liquids.isEmpty() || ingredients.isEmpty()) {
                    break;
                }

            }
        }
        if (cookedFoods.size() == 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
//            Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"
            System.out.print("Liquids left: ");
            liquids.forEach(e -> System.out.print(e + ", "));
            System.out.println();
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
//            Liquids left: {liquid1}, {liquid2}, {liquid3}, (…)"
//            System.out.print("Ingredients left: ");
//            ingredients.forEach(e -> System.out.print(e + ", "));
//            System.out.println();
            String ingredientsOutput = ingredients.stream()
                    .map(Objects::toString)
                    .collect(Collectors.joining(", ")).toString();
            System.out.println(ingredientsOutput);
        }
        cookedFoods.forEach((k, v) -> {
            System.out.print(k + ": " + v);
            System.out.println();
        });


    }
}