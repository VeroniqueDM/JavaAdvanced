package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> queue = new PriorityQueue<>();

        Collections.addAll(queue, kids);
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String movingKid = queue.poll();
                queue.offer(movingKid);
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());

            } else {
                System.out.println("Removed " + queue.poll());

            }
            cycle++;
        }
        System.out.printf("Last is %s", queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i <= cycle / 2; i++) {
            if ((cycle % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
