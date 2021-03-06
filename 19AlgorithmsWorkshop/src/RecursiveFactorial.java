import java.util.Scanner;

public class RecursiveFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        fact(num);

        System.out.println(fact(num));

    }

    static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
