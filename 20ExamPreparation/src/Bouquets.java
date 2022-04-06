import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // first line - stack - tulips
        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tulipsStack::push);

        // second line - queue - daffodils
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(daffodilsQueue::offer);

        //one bouquets needs 15 flowers.  goal - at least 5 bouquets
        int goal = 5;
        int oneBouquet = 15;
        int bouquetsCount = 0;
        List<Integer> forLater = new ArrayList<>();

        for (int tulip : tulipsStack) {
            for (int daffodil : daffodilsQueue) {
                if(tulipsStack.isEmpty() || daffodilsQueue.isEmpty()) {
                    break;
                }
                if (tulip + daffodil == oneBouquet) {
                    bouquetsCount++;
                    tulipsStack.pop();
                    daffodilsQueue.poll();
                } else if (tulip + daffodil > oneBouquet) {
                    while (tulip + daffodil > oneBouquet) {
                        tulip -= 2;
                    }
                    bouquetsCount++;
                    tulipsStack.pop();
                    daffodilsQueue.poll();

                } else if (tulip + daffodil < oneBouquet) {
                    forLater.add(tulip + daffodil);
                    tulipsStack.pop();
                    daffodilsQueue.poll();
                }
                break;
            }
        }
        int sumLeftElements = 0;
        for (int element:forLater) {
            sumLeftElements += element;
        }
        int leftBouqets = Math.abs(sumLeftElements / 15);
        bouquetsCount += leftBouqets;

        if (bouquetsCount >= goal) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsCount);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", goal - bouquetsCount);
        }

    }
}
