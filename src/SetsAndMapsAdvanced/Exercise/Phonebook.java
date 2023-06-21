package SetsAndMapsAdvanced.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String , String> phonebook = new HashMap<>();
        while (!command.equals("search")) {
            String [] info = command.split("-");
            String name = info[0];
            String phoneNum = info[1];
            phonebook.put(name,phoneNum);
            command = scanner.nextLine();
        }
        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n",name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scanner.nextLine();
        }
    }
}
