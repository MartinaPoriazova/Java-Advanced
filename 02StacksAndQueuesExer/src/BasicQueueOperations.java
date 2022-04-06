import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        // n брой пъти донавя към стека следващото число
        for (int i = 1; i <= n; i++) {
            queue.offer(scanner.nextInt());
        }
        // s брой пъти ma към стека следващото число
        for (int i = 1; i <= s; i++) {
            queue.poll();
        }
        // x да го има в стека
        if (queue.contains(x)) {
            System.out.println("true");
        } // x го няма в стека
        else {
            // min ел
            // имаме ел
            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue)); // от библиотеката Coll вадим готов метод за стека
            } else {
                System.out.println(0);
            }
        }
    }
}