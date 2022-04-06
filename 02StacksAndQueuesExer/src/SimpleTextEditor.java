import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> wordStates = new ArrayDeque<>();
        StringBuilder currentText = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            switch (command) {
                case "1":
                    String text = input[1];
                    currentText.append(text);
                    wordStates.push(currentText.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    int startIndex = currentText.length() - count;
                    currentText.delete(startIndex, startIndex + count);

//  2)             currentText = currentText.replace(startIndex, startIndex + count, "");
//  3)                  String textToDelete = currentText.substring(startIndex);
//                    currentText.toString().replaceFirst(textToDelete, "");
                    wordStates.push(currentText.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    System.out.println(currentText.charAt(index - 1));
                    break;
                case "4":
                    if (wordStates.size() > 1) {
                        wordStates.pop();
                        currentText = new StringBuilder(wordStates.peek());
                    } else {
                        currentText = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
