import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browser = new ArrayDeque<>();
        String line = scanner.nextLine();

        String current = "";

        while (!line.equals("Home")) {

            if (line.equals("back")) {

                if (!browser.isEmpty()) {
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }

            } else {

                if (!current.equals("")) {
                    browser.push(current);
                }

                current = line;
            }

            System.out.println(current);
            line = scanner.nextLine();
        }


    }
}

//        String command = scanner.nextLine();
//        ArrayDeque<String> history = new ArrayDeque<>();
//        String currentURL = "";
//
//        while (!command.equals("Home")) {
//            if (command.equals("back")) {
//                // back
//                if (history.isEmpty()) {
//                    currentURL = history.pop();
//                } else {
//                    System.out.println("no previous URLs");
//                    command = scanner.nextLine();
//                    continue;
//                }
//            } else {
//                if (!currentURL.equals("")) {
//                    history.push(currentURL);
//                }
//                currentURL = command;
//            }
//                System.out.println(currentURL);
//            command = scanner.nextLine();
//        }
//    }
//}
