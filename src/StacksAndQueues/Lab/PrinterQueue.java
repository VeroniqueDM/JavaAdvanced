package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String file = scanner.nextLine();

        while (!file.equals("print")) {
            if (file.equals("cancel")) {
                if (!queue.isEmpty()){
                    System.out.printf("Canceled %s%n",  queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(file);
            }
            file = scanner.nextLine();
        }
        while (!queue.isEmpty()) {
            String lastEL = queue.poll();
            System.out.println(lastEL);
        }
    }
}
