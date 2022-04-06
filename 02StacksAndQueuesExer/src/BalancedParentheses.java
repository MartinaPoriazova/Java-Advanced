import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // последната отворена да съвпада с първата затворена
        String input = scanner.nextLine();
        ArrayDeque<Character> opernBracket = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            // проверка дали скобата е отворена
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                opernBracket.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {

                if (opernBracket.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                // проверка дали затворената скоба съвада с последната отворена
                char lastOpenBracket = opernBracket.pop(); // ще вземе последната отворена скоба

                // ако отворена ( затворена )
                if (lastOpenBracket == '(' && currentBracket == ')') {
                    areBalanced = true;
                }
                // ако отворена { затворена }
                else if (lastOpenBracket == '{' && currentBracket == '}') {
                    areBalanced = true;
                }
                // ако отворена [ затворена ]
                else if (lastOpenBracket == '[' && currentBracket == ']') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
