import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // lilies - LIFO - Stack
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(liliesStack::push);
        // roses - FIFO - Queue
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(rosesQueue::offer);

        int oneWreath = 15;
        int goal = 5;
        int wreathCounter = 0;
        int flowersForLater = 0;

        for (int lily:liliesStack) {
            for (int rose:rosesQueue) {
                if (liliesStack.isEmpty() || rosesQueue.isEmpty()) {
                    break;
                }
                if (lily + rose == oneWreath) {
                    wreathCounter++;
                    liliesStack.pop();
                    rosesQueue.poll();
                } else if (lily + rose > oneWreath) {
                    while (lily + rose > oneWreath) {
                        lily -= 2;
                    }
                    wreathCounter++;
                    liliesStack.pop();
                    rosesQueue.poll();
                } else if (lily + rose < oneWreath) {
                    flowersForLater += lily + rose;
                    liliesStack.pop();
                    rosesQueue.poll();
                }
                break;
            }
        }
        if (flowersForLater >= oneWreath) {
            int wreathsFromLeftFlowers = Math.abs(flowersForLater / oneWreath);
            wreathCounter += wreathsFromLeftFlowers;
        }
        if (goal <= wreathCounter) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathCounter);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", goal - wreathCounter);
        }
    }
}
