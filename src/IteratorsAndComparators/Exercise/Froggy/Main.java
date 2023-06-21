package IteratorsAndComparators.Exercise.Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] nums = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
        Lake lake = new Lake(nums);
        List<String> print = new ArrayList<>();
        for (Integer item : lake) {
            print.add(String.valueOf(item));
        }

        System.out.println(String.join(", ", print));


    }
}
