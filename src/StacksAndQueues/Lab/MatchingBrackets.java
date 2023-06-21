package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        ArrayDeque<Integer> stackIndices = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (currentChar == '(') {
                stackIndices.push(i);
            } else if (currentChar == ')') {
                int lastOpenIndex = stackIndices.pop();
                String subexpression = expression.substring(lastOpenIndex,i+1);
                System.out.println(subexpression);
            }
        }

    }
}
