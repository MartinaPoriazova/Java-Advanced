import guild.Player;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Santas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // last - materials - Stack
        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(materialsStack::push);
        // first - magis - Queue
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(magicQueue::offer);
        Map<Integer, String> presents = new TreeMap<>();
        presents.put(150, "Doll");
        presents.put(250, "Wooden train");
        presents.put(300, "Teddy bear");
        presents.put(400, "Bicycle");

        Map<String, Integer> presentsCount = new TreeMap<>();
        presentsCount.put("Doll", 0);
        presentsCount.put("Wooden train", 0);
        presentsCount.put("Teddy bear", 0);
        presentsCount.put("Bicycle", 0);

        while (!materialsStack.isEmpty() || !magicQueue.isEmpty() ||
                (!materialsStack.isEmpty() && !magicQueue.isEmpty())) {
            int multi = (materialsStack.peek() * magicQueue.peek());
            if (presents.entrySet().stream().anyMatch(e -> e.getKey() == multi)) {
                String currentMaterial = presents.get(multi);
                presentsCount.put(currentMaterial, presentsCount.get(currentMaterial) + 1);
                materialsStack.pop();
                magicQueue.poll();
            } else {
                if (multi < 0) {
                    int sum = materialsStack.peek() + magicQueue.peek();
                    materialsStack.pop();
                    magicQueue.poll();
                    materialsStack.push(sum);
                }
                if (multi >= 0 && (presents.entrySet().stream().anyMatch(e -> e.getKey() != multi))) {
                    magicQueue.poll();
                    materialsStack.push(materialsStack.pop() + 15);
                }
                if (materialsStack.peek() == 0 && magicQueue.peek() == 0) {
                    if (materialsStack.peek() == 0) {
                        materialsStack.pop();
                    } else if (magicQueue.peek() == 0) {
                        magicQueue.poll();
                    } else {
                        materialsStack.pop();
                        magicQueue.poll();
                    }
                }
            }
        }
        if ((presentsCount.get("Doll") > 0 && presentsCount.get("Wooden train") > 0) ||
                (presentsCount.get("Teddy bear") > 0 && presentsCount.get("Bicycle") > 0)){
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(materialsStack.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        if (!magicQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magicQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        Map<String, Integer> finalPresents = new TreeMap<>();
        presentsCount.entrySet().forEach(entry ->
                System.out.printf("%s: %d\n", entry.getKey(), entry.getValue() > 0)

                ) ;

//        presentsCount.forEach((k, v) ->
//                        System.out.printf("%s: %d\n", k, v));

//    Player[] playersToRemove = roster.values().stream()
//                .filter(p -> p.getClazz().equals(clazz))
//                .toArray(Player[]::new);

    }
}
