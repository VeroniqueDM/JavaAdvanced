package Generics.Exercise.Box;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box> boxesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Double input = Double.valueOf(scanner.nextLine());
            Box<Double> box = new Box<>(input);
            boxesList.add(box);
        }
        Box compareValue = new Box<>(Double.valueOf(scanner.nextLine()));
        System.out.println(Box.countGreaterElements(boxesList,compareValue));
//        String[] indices = scanner.nextLine().split("\\s+");
//        int firstIndex = Integer.parseInt(indices[0]);
//        int secondIndex = Integer.parseInt(indices[1]);
//        Box.swapIndices(firstIndex,secondIndex,boxesList);
//        boxesList.forEach(System.out::println);
    }
//    public static <T extends Comparable<T>> int countGreaterElements(List<Box<T>> boxList, T element) {
//            Box newBox = new Box<>(element);
//
//        List<T> filteredList = boxList.stream().filter(el -> el.compareTo(element)>0).collect(Collectors.toList());
//        return filteredList.size();
//    }
}
