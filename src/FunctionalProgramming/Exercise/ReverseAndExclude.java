package FunctionalProgramming.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numsArr = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int excludedDivNum = Integer.parseInt(scanner.nextLine());
        Function<List<Integer>, List<Integer>> reverseList = list -> {
            List<Integer> reversedList = new ArrayList<>();
            int index = 0;
            for (int i = list.size()-1; i >=0 ; i--) {
                reversedList.add(list.get(i));
                index++;
            }
            return reversedList;
        };
        Function<List<Integer>,List<Integer>> excludingNums = arr -> arr.stream().filter((n-> n%excludedDivNum!=0)).collect(Collectors.toList());
        numsArr = reverseList.apply(numsArr);
        numsArr = excludingNums.apply(numsArr);
        for (int num : numsArr) {
            System.out.print(num+ " ");
        }

    }
}
