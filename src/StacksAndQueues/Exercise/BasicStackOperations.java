package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split("\\s+");
        int amountToPush = Integer.parseInt(info[0]);
        int amountToPop = Integer.parseInt(info[1]);
        int intToCheck = Integer.parseInt(info[2]);
        ArrayDeque<String> numsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(numsStack::push);

        for (int i = 0; i < amountToPop; i++) {
            numsStack.pop();
        }

        if (numsStack.contains(Integer.toString(intToCheck))) {
            System.out.println(true);
        } else {
            if (numsStack.isEmpty()) {
                System.out.println(0);
            } else {
                int minNum = Integer.MAX_VALUE;
                while (!numsStack.isEmpty()){
                    int currentNum = Integer.parseInt(numsStack.pop());
                    if(currentNum<minNum){
                        minNum=currentNum;
                    }
                }
                System.out.println(minNum);
            }

        }

    }
}
