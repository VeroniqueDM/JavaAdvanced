package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size()<capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                return this.vehicles.remove(vehicle);
            }
        }
        return false;
    }

    public Vehicle getLowestMileage() {
        return vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).orElse(null);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getCount() {
        return this.getVehicles().size();
    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");
        if (this.vehicles.size()>0){
            sb.append(System.lineSeparator());
        }
        for (Vehicle vehicle : this.vehicles) {
            sb.append(String.format("%s", vehicle)).append(System.lineSeparator());
        }
        return String.valueOf(sb);
    }
}
