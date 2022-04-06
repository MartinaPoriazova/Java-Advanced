import java.util.ArrayDeque;
import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        StringBuilder text1 = new StringBuilder();
        ArrayDeque<String> texts = new ArrayDeque<>();
        String text = "";
        text1.append(text);

        for (int i = 1; i <= N; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            switch (input[0]) {
                case "1":
                    String string = input[1];
                    text1.append(string);
                    texts.push(text1.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    text1.delete(text1.length() - count, text1.length());
                    texts.push(text1.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    System.out.println(text1.charAt(index - 1));
                    break;
                case "4":
                    if (texts.size() > 1) {
                        texts.pop();
                        text1 = new StringBuilder(texts.peek());
                    } else {
                        text1 = new StringBuilder();
                    }
                    break;
            }
        }

    }
}
