package DefiningClasses.Lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < n; i++) {
//            String[] nextCar = scanner.nextLine().split("\\s+");
//            Car car = new Car(nextCar[0],nextCar[1],Integer.parseInt(nextCar[2]));
//            System.out.println(car.carInfo());
//        }
        List<Car> carInfo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] nextCar = scanner.nextLine().split("\\s+");
            if (nextCar.length == 3) {
                Car car = new Car(nextCar[0], nextCar[1], Integer.parseInt(nextCar[2]));
                carInfo.add(car);
                System.out.println(car.carInfo());

            } else {
                Car car = new Car(nextCar[0]);
                carInfo.add(car);
                System.out.println(car.carInfo());

            }

        }
    }
}
