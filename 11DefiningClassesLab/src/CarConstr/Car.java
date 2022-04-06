package CarConstr;

public class Car {

    private String brand;
    private String model;
    private int horsePower;

    public Car(String carBrand, String carModel, int hp) {
        brand = carBrand;
        model = carModel;
        horsePower = hp;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

}
