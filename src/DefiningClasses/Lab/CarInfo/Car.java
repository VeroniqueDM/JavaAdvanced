package DefiningClasses.Lab.CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand, String model, int horsepower) {
        // CONSTRUCTOR CHAINING
        this(brand);
        this.model = model;
        this.horsepower = horsepower;
    }

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String carInfo() {
        String output = "The car is: " + this.brand + " " + this.model + " - " + this.horsepower + " HP.";
        return output;
    }
}
