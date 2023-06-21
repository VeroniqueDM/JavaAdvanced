package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //        double[] numsArr2= Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        List<Double> numsArr = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        Map<Double, Integer> occuranceMap = new LinkedHashMap<>();

        for (Double num :
                numsArr) {
            if (occuranceMap.containsKey(num)) {

                occuranceMap.put(num, occuranceMap.get(num) +1);
            } else {
                occuranceMap.put(num,1);
            }

        }

        for (Map.Entry<Double, Integer> num :
                occuranceMap.entrySet()) {
            System.out.printf("%.1f -> %d%n",num.getKey(),num.getValue());
        }

    }
}
