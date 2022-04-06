package Collection;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ListyIterator listyIterator = null;

        while (!line.equals("END")) {
            String[] commandParts = line.split(" ");
            String commandName = commandParts[0];

            switch (commandName) {
                case "Create":
                    if (commandParts.length > 1) {
//                      listyIterator = new ListyIterator(Arrays.copyOfRange(commandParts, 1, commandParts.length));
                        listyIterator = new ListyIterator(Arrays.copyOfRange(commandParts, 1, commandParts.length));
                        Arrays.stream(commandParts).skip(1).collect(Collectors.toList());
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
