package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
        //Predicate<Car> foundCar = car -> car.getManufacturer().equals(manufacturer) &&
        //                car.getModel().equals(model);
        //        boolean isRemoved = this.data.removeIf(foundCar);
        //        if (isRemoved) {
        //            this.capacity++;
        //        }
        //        return isRemoved;
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }
//" The cars are in a car dealership {name}:
//{Car1}
//{Car2}
//(…)"

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder("The cars are in a car dealership " +
                this.name + ":" + System.lineSeparator());
        for (Car car:data) {
            stringBuilder.append(car).append("\n");
        }
        return stringBuilder.toString();
    }
}
