package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) &&
                car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }


    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer) &&
                car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        //// The cars are parked in Underground parking garage:
        //// Peugeot 307 (2011)
        //// Audi S4 (2005)
        StringBuilder stringBuilder = new StringBuilder("The cars are parked in " + this.type + ":" +
                System.lineSeparator());
        for (Car car : data) {
            stringBuilder.append(car.getManufacturer()).append(" ").append(car.getModel()).append(" ")
                    .append("(").append(car.getYear()).append(")").append("\n");
        }
        return stringBuilder.toString().trim();
    }
}
