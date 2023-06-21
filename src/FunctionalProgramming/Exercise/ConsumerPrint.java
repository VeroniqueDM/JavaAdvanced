package FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        Consumer<String> print = name -> System.out.println(name);
        for (String name :
                words) {
            print.accept(name);
        }

    }
}
