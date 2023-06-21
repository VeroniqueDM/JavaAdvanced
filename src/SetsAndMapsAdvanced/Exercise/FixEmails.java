package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, String> mailBook = new LinkedHashMap<>();
        int counter = 1;
        String name = "";
        String email = "";
        while (!command.equals("stop")) {
            if (counter % 2 == 0) {
                email = command;
                if (email.endsWith("us") || email.endsWith("uk") || email.endsWith("com")) {
                    counter++;
                    command = scanner.nextLine();
                    continue;
                } else {
                    mailBook.put(name, email);
                }
            } else {
                name = command;
            }
            counter++;
            command = scanner.nextLine();
        }
        mailBook.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }
}
