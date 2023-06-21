package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> doubles = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());

        Function<List<Double>,List<Double>> addVat = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i,list.get(i)*1.2);
            }
            return list;
        };
        doubles = addVat.apply(doubles);
        System.out.println("Prices with VAT:");
        doubles.forEach(num-> System.out.printf("%.2f%n",num));
    }
}
