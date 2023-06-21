package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numsStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            if (command.length>1) {
                int newNum = Integer.parseInt(command[1]);
                numsStack.push(newNum);
            } else {
                if (command[0].equals("2")){
                    numsStack.pop();
                } else {
                    System.out.println(Collections.max(numsStack));
                }
            }
        }
    }
}
