package RawData;

import java.util.ArrayList;

public class Car { //model, engine, cargo and a collection of exactly 4 tires
    private String model;
    private RawData.Engine engine;
    private Cargo cargo;
    private ArrayList<Tires> tires;

    public Car (String model, RawData.Engine engine, Cargo cargo, ArrayList<Tires> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(RawData.Engine engine) {
        this.engine = engine;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setTires(ArrayList<Tires> tires) {
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public ArrayList<Tires> getTires() {
        return tires;
    }
    @Override
    public String toString() {
        return String.format("%s", this.model);
    }
}
