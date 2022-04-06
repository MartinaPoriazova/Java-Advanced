import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 10; i++) {
            smartArray.add(i + 1);
        }
        smartArray.remove(3);

        System.out.println();

    }
}
