package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue,kids);
        while (queue.size()>1){
            for (int i = 1; i < n; i++) {
                String movingKid = queue.poll();
                queue.offer(movingKid);
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.printf("Last is %s", queue.poll());
    }
}
