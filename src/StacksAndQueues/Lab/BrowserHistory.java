package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String command = scanner.nextLine();

        while (!command.equals("Home")){
            if (command.equals("back")){
                if (stack.size() <= 1){
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                stack.push(command);
                System.out.println(stack.peek());
            }




            command=scanner.nextLine();

        }
    }
}
