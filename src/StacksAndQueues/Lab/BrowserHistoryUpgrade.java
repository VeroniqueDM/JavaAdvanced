package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String command = scanner.nextLine();

        while (!command.equals("Home")){
            if (command.equals("back")){
                if (history.size() <= 1){
                    System.out.println("no previous URLs");
                } else {
                    history.pop();
                    System.out.println(history.peek());
                }
            } else if (command.equals("forward")) {
                if (forward.isEmpty()){
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.peek());
                    history.push(forward.pop());
                }
            } else {
                history.push(command);
                System.out.println(history.peek());
                forward.clear();
            }




            command=scanner.nextLine();

        }
    }
}
