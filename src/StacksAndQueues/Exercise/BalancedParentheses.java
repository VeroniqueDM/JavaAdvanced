package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        ArrayDeque<String> closingBrackets = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '[' || currentChar == '(' || currentChar == '{'){
                openingBrackets.push(currentChar);
            }else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                if ((currentChar == ')' && openingBrackets.peek() == '(') || (currentChar == ']' && openingBrackets.peek() == '[') || (currentChar == '}' && openingBrackets.peek() == '{')) {
                    openingBrackets.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
