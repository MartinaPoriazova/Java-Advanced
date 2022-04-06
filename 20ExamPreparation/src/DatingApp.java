import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // last males - Stack
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);
        // first female - Queue
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(femalesQueue::offer);
        int machCounter = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();
            if (female <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (male <= 0) {
                malesStack.pop();
                continue;
            }
            if (female % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (malesStack.peek() == femalesQueue.peek()) {
                machCounter++;
                femalesQueue.poll();
                malesStack.pop();
            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }
        }
        System.out.println("Matches: " + machCounter);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " + malesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " + femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
