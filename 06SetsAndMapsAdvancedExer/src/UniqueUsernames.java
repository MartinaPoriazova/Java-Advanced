import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String input = scanner.nextLine();
            usernames.add(input);
        }
        usernames.forEach(System.out::println);
    }
}
