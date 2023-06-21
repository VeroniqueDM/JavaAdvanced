package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> numsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(numsStack::push);


        while (!numsStack.isEmpty()) {
            System.out.printf("%s ",numsStack.pop());
        }

    }
}
