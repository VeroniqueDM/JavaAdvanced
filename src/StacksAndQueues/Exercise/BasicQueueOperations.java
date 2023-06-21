package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split("\\s+");
        int amountToOffer = Integer.parseInt(info[0]);
        int amountToPoll = Integer.parseInt(info[1]);
        int intToCheck = Integer.parseInt(info[2]);
        ArrayDeque<String> numsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(numsQueue::offer);

        for (int i = 0; i < amountToPoll; i++) {
            numsQueue.poll();
        }

        if (numsQueue.contains(Integer.toString(intToCheck))) {
            System.out.println(true);
        } else {
            if (numsQueue.isEmpty()) {
                System.out.println(0);
            } else {
                int minNum = Integer.MAX_VALUE;
                while (!numsQueue.isEmpty()){
                    int currentNum = Integer.parseInt(numsQueue.pop());
                    if(currentNum<minNum){
                        minNum=currentNum;
                    }
                }
                System.out.println(minNum);
            }

        }

    }
}
