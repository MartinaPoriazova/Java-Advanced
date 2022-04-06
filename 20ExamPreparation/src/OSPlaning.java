import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] taskData = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] threadData = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> task = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(taskData).forEach(task::push);
        Arrays.stream(threadData).forEach(threads::offer);
        int taskRemove = Integer.parseInt(scanner.nextLine());
        while (!task.isEmpty() || !threads.isEmpty()) {
            if (task.isEmpty() || threads.isEmpty()) {
                break;
            }
            int taskValue = task.peek();
            int threadsValue = threads.peek();
            if (threadsValue >= taskValue && taskValue != taskRemove) {
                task.pop();
                threads.poll();
            } else {
                if (taskValue != taskRemove) {
                    threads.pop();
                } else {
                    System.out.printf("Thread with value %d killed task %d%n", threadsValue, taskValue);
                    while (!threads.isEmpty()) {
                        System.out.print(threads.poll() + " ");
                    }
                }
            }
        }
    }
}