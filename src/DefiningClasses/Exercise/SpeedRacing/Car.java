package DefiningClasses.Exercise.SpeedRacing;

import java.util.Map;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }


    public void drive(int amountOfKm, String model, Map<String, Car> carMap) {
        double fuelNeeded = amountOfKm * carMap.get(model).getFuelCost();
        double fuelNow = carMap.get(model).getFuelAmount();
        if (fuelNeeded > fuelNow) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            double fuel = carMap.get(model).getFuelAmount() - fuelNeeded;
            int distance = carMap.get(model).getDistanceTravelled() + amountOfKm;
            carMap.get(model).setFuelAmount(fuel);
            carMap.get(model).setDistanceTravelled(distance);

        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTravelled);
    }
}
