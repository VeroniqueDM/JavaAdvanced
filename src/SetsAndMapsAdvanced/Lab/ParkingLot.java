package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> hashSet = new LinkedHashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("END")){
            String direction = command.split(", ")[0];
            String carPlate = command.split(", ")[1];
            if (direction.equals("IN")){
                hashSet.add(carPlate);
            } else {
                hashSet.remove(carPlate);

            }
            command = scanner.nextLine();
        }
        if (hashSet.size()==0){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car :
                    hashSet) {
                System.out.println(car);
            }
        }

    }
}
