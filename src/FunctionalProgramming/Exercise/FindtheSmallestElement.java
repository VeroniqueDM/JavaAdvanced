package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindtheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numsList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestNumIndex = list -> {
            int minNum = Integer.MAX_VALUE;
            int minNumInd = -1;
            for (int i = list.size()-1; i >=0; i--) {
                if (list.get(i)<minNum) {
                    minNum = list.get(i);
                    minNumInd = i;

                }
            }
            return minNumInd;
        };
        int minNum = findSmallestNumIndex.apply(numsList);
        System.out.println(minNum);
    }
}
