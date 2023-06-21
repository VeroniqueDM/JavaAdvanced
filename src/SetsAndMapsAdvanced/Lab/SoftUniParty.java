package SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> guestsList = new TreeSet<>();
        String command = scanner.nextLine();
        while (!command.equals("PARTY")){
            guestsList.add(command);
            command = scanner.nextLine();
        }
        while (!command.equals("END")){
            guestsList.remove(command);
            command = scanner.nextLine();
        }
        System.out.println(guestsList.size());
        for (String guest :
                guestsList) {
            System.out.println(guest);
        }
    }
}
