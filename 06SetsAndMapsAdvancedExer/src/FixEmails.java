import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> map = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String mail = scanner.nextLine();
            if (!mail.endsWith("us") && !mail.endsWith("uk") && !mail.endsWith("com")) {
                map.put(name, mail);
            }
            name = scanner.nextLine();
        }
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
