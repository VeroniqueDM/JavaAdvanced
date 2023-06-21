package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> findMin = (int[] arr) -> {
            int minNum = Integer.MAX_VALUE;
            for (Integer num :
                    arr) {
                if (num < minNum) {
                    minNum = num;
                }
                }
            return minNum;
        };
        System.out.println(findMin.apply(numsArr));
    }
}
