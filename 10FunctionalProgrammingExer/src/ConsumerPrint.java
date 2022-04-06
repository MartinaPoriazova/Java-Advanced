import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Function<приема, връща> -> apply
//        Consumer<приема> -> void -> accept
//        Supplier<връща> -> get
//        Predicate<приема> -> false / true -> test
//        BiFunction<приема1, приема2, връща> -> apply

        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

        // 1 :
//        for (String name:names) {
//            System.out.println(name);
//        }
        // 2:
        // Име -> печатаме
        Consumer<String> printName = name -> System.out.println(name);
        for (String name : names) {
            printName.accept(name);
        }
        // 3:
        // Масив с имена -> печата
        Consumer<String[]> printNames = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };
        printNames.accept(names);
    }
}
