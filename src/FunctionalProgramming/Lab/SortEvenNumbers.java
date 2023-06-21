package FunctionalProgramming.Lab;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numsArr = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).filter(x -> x%2==0).collect(Collectors.toList());
//        numsArr = numsArr.stream().filter(x -> x%2==0).collect(Collectors.toList());
//        numsArr.forEach(System.out::print);
        printListWithComma(numsArr);
//        numsArr.forEach(n -> System.out.printf("%d, ",n));
        Collections.sort(numsArr);
        printListWithComma(numsArr);
    }

    private static void printListWithComma(List<Integer> numsArr) {
       List<String> numsAsText  = numsArr.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(", ", numsAsText));
    }
}
