import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expressionElements = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        // Collections.addAll(stack, expressionElements);

        for (int i = expressionElements.length - 1; i >= 0; i--) {
            stack.push(expressionElements[i]);
        }

        while (stack.size() > 1) {
            int leftOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int rightOperand = Integer.parseInt(stack.pop());

        // ако операторът е плюс върни ... ако не е ... ..?..:..
            int result = operator.equals("+")
                    ? leftOperand + rightOperand
                    : leftOperand - rightOperand;
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.pop());
    }
}
