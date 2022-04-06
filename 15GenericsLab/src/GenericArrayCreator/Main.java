package GenericArrayCreator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] integers = ArrayCreator
                .<Integer>create(10, 13);

        String[] strings = ArrayCreator
                .<String>create(String.class, 3, "Java");

        for (Integer integer : integers) {
            System.out.println(integer);
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
