import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstSequence = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSequence = new LinkedHashSet<>();
        String[] input = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int countAll = N + M;

        for (int i = 1; i <= N; i++) {
            int numberN = Integer.parseInt(scanner.nextLine());
            firstSequence.add(numberN);
        }
        for (int i = 1; i <= M; i++) {
            int numberM = Integer.parseInt(scanner.nextLine());
            secondSequence.add(numberM);
        }
//        LinkedHashSet<Integer> duplicatedElements = new LinkedHashSet<>();
//        for (int num : firstSequence) {
//            if (secondSequence.contains(num)) {
//                duplicatedElements.add(num);
//            }
//        }
        firstSequence.retainAll(secondSequence);
        firstSequence.forEach(num -> System.out.print(num + " "));
    }
}
