package RawData;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Tires> tires = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            //{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age}
            // {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}",
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Tires tire = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            tires.add(tire);
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String commnand = scanner.nextLine();
        ArrayList<String> model = new ArrayList<>();
        switch (commnand) {
            case "fragile":
                for (int j = 0; j < cars.size(); j++) {
                    if (cars.get(j).getTires().get(j).getTire1Pressure() < 1 ||
                            cars.get(j).getTires().get(j).getTire2Pressure() < 1 ||
                            cars.get(j).getTires().get(j).getTire3Pressure() < 1 ||
                            cars.get(j).getTires().get(j).getTire4Pressure() < 1) {
                            model.add(cars.get(j).getModel());
                    }
                }
                break;
            case "flamable":
                cars.forEach(e -> {
                    if (e.getCargo().getCargoType().equals("flamable") &&
                            e.getEngine().getEnginePower() > 250) {
                        model.add(e.getModel());
                    }
                });
                break;
        }
        model.forEach(System.out::println);
    }
}
