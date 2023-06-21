package DefiningClasses.RawData;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        // "{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}
        // {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}",
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            EngineE engine = new EngineE(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Tires tires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                for (Car car : cars) {
                    if (car.getTires().ifTirePressureIsUnder() && car.getCargo().getType().equals("fragile")) {
                        System.out.printf("%s%n", car.getModel());
                    }
                }
                break;
            case "flamable":
                for (Car car : cars) {
                    if (car.getEngine().getPower()>250 && car.getCargo().getType().equals("flamable")) {
                        System.out.printf("%s%n", car.getModel());
                    }
                }
                break;
        }
    }}
