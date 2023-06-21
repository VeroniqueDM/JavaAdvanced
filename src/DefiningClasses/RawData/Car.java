package DefiningClasses.RawData;

import CarSalesman.Engine;

public class Car {
    private String model;
    private EngineE engine;
    private Cargo cargo;
    private Tires tires;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public EngineE getEngine() {
        return engine;
    }

    public void setEngine(EngineE engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    public Car(String model, EngineE engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }
}
