import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String sequence = scanner.nextLine();

        for (int i = 0; i < sequence.length(); i++) {
            char ch = sequence.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                int startIndex = stack.pop();
                String contest = sequence.substring(startIndex, i + 1);
                System.out.println(contest);
            }
        }
    }
}
