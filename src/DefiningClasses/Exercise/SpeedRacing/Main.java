package DefiningClasses.Exercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            double fuelAmount = Double.parseDouble(carInfo[1]);
            double fuelCost = Double.parseDouble(carInfo[2]);
            Car car = new Car(model,fuelAmount,fuelCost);
            carMap.put(model,car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandsLine = command.split("\\s+");
            String model = commandsLine[1];
            int amountOfKm = Integer.parseInt(commandsLine[2]);
            carMap.get(model).drive(amountOfKm,model,carMap);
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Car> carEntry : carMap.entrySet()) {
            System.out.println(carEntry.getValue());
        }
    }
}
