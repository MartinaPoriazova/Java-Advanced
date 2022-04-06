package CarInfo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Car car = new Car();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String carName = input[0];
            String carModel = input[1];
            int carHp = Integer.parseInt(input[2]);
            car.setBrand(carName);
            car.setModel(carModel);
            car.setHorsePower(carHp);

            System.out.println(car);
        }
    }
}
