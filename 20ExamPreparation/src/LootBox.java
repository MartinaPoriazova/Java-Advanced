import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox {
    public static int goal = 100;
    public static int sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // first - fifo - Queue
        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstBoxQueue::offer);
        // second - lifo - Stack
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBoxStack::push);

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int sumOfElements = firstBoxQueue.peek() + secondBoxStack.peek();

            if (sumOfElements % 2 == 0) {
                sum += sumOfElements;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQueue.offer(secondBoxStack.peek());
                secondBoxStack.pop();
            }


        }
        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }
        if (sum >= goal) {
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}

