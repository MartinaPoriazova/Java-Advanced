import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // first line - stack - tasks
        ArrayDeque<Integer> stackTasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stackTasks::push);

        // second line - queue - threads
        ArrayDeque<Integer> queueThreads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queueThreads::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        for (int task : stackTasks) {
            for (int thread : queueThreads) {
                if (task == taskToKill) {
                    System.out.printf("Thread with value %d killed task %d\n", thread, taskToKill);
                    System.out.println(queueThreads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                    break;
                }
                if (thread >= task) {
                    stackTasks.pop();
                    queueThreads.poll();
                } else {
                    queueThreads.poll();
                    continue;
                }
                break;
            }
        }
    }
}
