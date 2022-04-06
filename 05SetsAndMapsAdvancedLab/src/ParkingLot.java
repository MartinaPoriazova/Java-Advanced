import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> parking = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String registration = tokens[1];

            switch (command) {
                case "IN":
                    parking.add(registration);
                    break;
                case "OUT":
                    parking.remove(registration);
                    break;
            }
            input = scanner.nextLine();
        }
//        if (parking.isEmpty()) {
//            System.out.println("");
//        } else {
//
//        }
        String output = parking.isEmpty()
                ? "Parking Lot is Empty"
                : parking.stream()
                        .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(output);
    }
}
