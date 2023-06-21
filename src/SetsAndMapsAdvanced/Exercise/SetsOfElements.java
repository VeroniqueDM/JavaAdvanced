package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lengths = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstLength = lengths[0];
        int secondLength = lengths[1];
        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();
        for (int i = 0; i < firstLength; i++) {
            int newNum = Integer.parseInt(scanner.nextLine());
            setOne.add(newNum);
        }
        for (int i = 0; i < secondLength; i++) {
            int newNum = Integer.parseInt(scanner.nextLine());
            setTwo.add(newNum);
        }
        setOne.retainAll(setTwo);
        for (Integer num:
setOne      ) {
            System.out.printf("%d ", num);

        }
//        List<Integer> repeatedNums = new ArrayList<>();
//        for (Integer num :
//                setOne) {
//            if (setTwo.contains(num)) {
//                repeatedNums.add(num);
//            }}
//        for (int i = 0; i < repeatedNums.size(); i++) {
//            System.out.printf("%d ", repeatedNums.get(i));
//        }
    }
}
