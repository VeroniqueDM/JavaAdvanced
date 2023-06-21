package ExamPreparationTwo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(malesStack::push);
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(femalesQueue::offer);
        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();
            if (male <= 0 || female <= 0) {
                if (male <= 0) {
                    if (female <= 0) {
                        malesStack.pop();
                        femalesQueue.poll();
                        continue;
                    }
                    malesStack.pop();
                    continue;
                } else if (female <= 0) {
                    femalesQueue.poll();
                    continue;
                }
            }
            if (male%25== 0 || female%25 == 0) {
                if (male%25== 0) {
                    if (female%25 == 0) {
                        malesStack.pop();
                        malesStack.pop();
                        femalesQueue.poll();
                        femalesQueue.poll();
                        continue;
                    }
                    malesStack.pop();
                    malesStack.pop();
                    continue;
                } else if (female%25 == 0) {
                    femalesQueue.poll();
                    femalesQueue.poll();
                    continue;
                }
            }
            if (male == female) {
                malesStack.pop();
                femalesQueue.poll();
                matches++;
            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop()-2);
            }
        }
        System.out.printf("Matches: %d%n", matches);
        if (!malesStack.isEmpty()) {
            System.out.print("Males left: ");
            System.out.println(malesStack.toString().replace("[", "").replace("]", ""));


        } else {
            System.out.println("Males left: none");

        }
        if (!femalesQueue.isEmpty()) {
            System.out.print("Females left: ");
            System.out.println(femalesQueue.toString().replace("[", "").replace("]", ""));


        } else {
            System.out.println("Females left: none");

        }
    }
}
