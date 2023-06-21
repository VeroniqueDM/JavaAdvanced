package FunctionalProgramming.Exercise;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> multiply = nums -> {

            int[] newNums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i]*2;
            }
            return newNums;
        };
        Function<int[], int[]> add = nums -> {
            int[] newNums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i]+1;
            }
            return newNums;
        };
        Function<int[], int[]> subtract = nums -> {
            int[] newNums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i]-1;
            }
            return newNums;
        };
        Consumer<int[]> print = nums -> {
            for (int num :
                    nums) {
                System.out.print(num + " ");
            }
        };
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.equals("add")) {
                int[] newArr = add.apply(numsArr);
                numsArr = newArr;
            } else if (command.equals("subtract")) {
                int[] newArr = subtract.apply(numsArr);
                numsArr = newArr;
            } else if (command.equals("multiply")) {
                int[] newArr =  multiply.apply(numsArr);
                numsArr = newArr;

            } else {
                print.accept(numsArr);
            }

            command = scanner.nextLine();
        }
    }
}
