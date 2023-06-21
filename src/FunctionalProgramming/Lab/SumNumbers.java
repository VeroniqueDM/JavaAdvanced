package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        int count = numsList.size();
        Function<List<Integer>, Integer> sum = list -> {
            int sumNumbers = 0;
            for (int number : list) {
                sumNumbers += number;
            }

            return sumNumbers;
        };
        System.out.printf("Count = %d%n",count);

        System.out.printf("Sum = %d",sum.apply(numsList));
    }


}
