package CarSalesman;

import java.util.*;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();
        Map<String, Engine> engines = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokensEngine = scanner.nextLine().split("\\s+");
            Engine engine;
            String model = tokensEngine[0];
            int power = Integer.parseInt(tokensEngine[1]);
            if (tokensEngine.length == 2) {
                engine = new Engine(model, power);
            } else if (tokensEngine.length == 3) {
                if (isNumeric(tokensEngine[2])) {
                    int displacement = Integer.parseInt(tokensEngine[2]);
                    engine = new Engine(model, power, displacement);

                } else {
                    String efficiency = tokensEngine[2];
                    engine = new Engine(model, power, efficiency);

                }
            } else {
                String efficiency = tokensEngine[3];
                int displacement = Integer.parseInt(tokensEngine[2]);

                engine = new Engine(model, power, displacement, efficiency);

            }
            engines.put(model, engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] tokensCar = scanner.nextLine().split("\\s+");
            Car car;
            String model = tokensCar[0];
            Engine engine = engines.get(tokensCar[1]);
            if (tokensCar.length == 2) {
                car = new Car(model, engine);
            } else if (tokensCar.length == 3) {
                if (isNumeric(tokensCar[2])) {
                    int weight = Integer.parseInt(tokensCar[2]);
                    car = new Car(model,engine,weight);
                } else {
                    String color = tokensCar[2];
                    car = new Car(model,engine,color);
                }

            } else {
                String color = tokensCar[3];
                int weight = Integer.parseInt(tokensCar[2]);
                car = new Car(model, engine, weight, color);

            }
            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car);
        }
    }




    public static boolean isNumeric(String strNum) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}