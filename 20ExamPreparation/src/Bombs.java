import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // fifo - effect - Queue
        ArrayDeque<Integer> effectsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(effectsQueue::offer);
        // lifo - casing - Stack
        ArrayDeque<Integer> casingsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(casingsStack::push);

        Map<Integer, String> materials = new TreeMap<>();
        materials.put(40, "Datura Bombs");
        materials.put(60, "Cherry Bombs");
        materials.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> bombsCount = new TreeMap<>();
        bombsCount.put("Datura Bombs", 0);
        bombsCount.put("Cherry Bombs", 0);
        bombsCount.put("Smoke Decoy Bombs", 0);

        while (!effectsQueue.isEmpty() && !casingsStack.isEmpty()) {
            int sum = effectsQueue.peek() + casingsStack.peek();
            if (materials.entrySet().stream().anyMatch(e -> e.getKey() == sum)) {
                String material = materials.get(sum);
                bombsCount.put(material, bombsCount.get(material) + 1);
                effectsQueue.poll();
                casingsStack.pop();
            } else {
                casingsStack.push(casingsStack.poll() - 5);
            }
            if (bombsCount.entrySet().stream().allMatch(e -> e.getValue() >= 3)) {
                break;
            }
            if (effectsQueue.isEmpty() || casingsStack.isEmpty()) {
                break;
            }
        }
        if (bombsCount.values().stream().allMatch(f -> f >= 3)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if (!effectsQueue.isEmpty()) {
            System.out.println(effectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("empty");
        }
        System.out.print("Bomb Casings: ");
        if (!casingsStack.isEmpty()) {
            System.out.println(casingsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("empty");
        }

        bombsCount.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));
    }
}
