import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);
        int itemsWorth = 0;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstItem = queue.peek();
            int secondItem = stack.peek();
            int sum = firstItem + secondItem;
            if (sum % 2 == 0) {
                itemsWorth += sum;
                queue.poll();
            } else {
                queue.offer(secondItem);
            }
            stack.pop();
            if (queue.isEmpty()) {
                System.out.println("First magic box is empty.");
            }
            if (stack.isEmpty()) {
                System.out.println("Second magic box is empty.");
            }
        }
        if (itemsWorth >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + itemsWorth);
        } else {
            System.out.println("Poor prey... Value: " + itemsWorth);
        }
    }
}
