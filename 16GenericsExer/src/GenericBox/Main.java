package GenericBox;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box();

        for (int i = 0; i < n; i++) {
            double value = Double.parseDouble(scanner.nextLine());
            box.add(value);
        }
        double elementToCompare = Double.parseDouble(scanner.nextLine());

        int GreaterElementsCount = box.countOfGreaterItems(elementToCompare);

// 4       String[] indices = scanner.nextLine().split(" ");
//        int first = Integer.parseInt(indices[0]);
//        int second = Integer.parseInt(indices[1]);
//        box.swap(first, second);

        System.out.println(GreaterElementsCount);
    }
}
