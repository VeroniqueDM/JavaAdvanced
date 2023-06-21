package Generics.Exercise.CustomList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.forEach(System.out::println);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
//            applyCommand(tokens,customList);
            input = scanner.nextLine();
        }

    }

//    private static void applyCommand(String[] tokens,CustomList<String> customList) {
//        if (tokens[0].equals("Add")) {
//            add(tokens,customList);
//        } else if (tokens[0].equals("Remove")) {
//            remove(tokens,customList);
//        } else if (tokens[0].equals("Contains")) {
//            checkContains(tokens,customList);
//        } else if (tokens[0].equals("Swap")) {
//            swap(tokens,customList);
//        } else if (tokens[0].equals("Greater")) {
//            countGreaterThan(tokens,customList);
//        } else if (tokens[0].equals("Max")) {
//            findMax(customList);
//        } else if (tokens[0].equals("Min")) {
//            findMin(customList);
//        } else if (tokens[0].equals("Print")) {
//            printAll(customList);
//        }
//    }
//
//    private static void printAll(CustomList<String> customList) {
//        System.out.println(customList);
//    }
//
//    private static void findMin( CustomList<String> customList) {
//        System.out.println(customList.getMin());
//
//    }
//
//    private static void findMax(CustomList<String> customList) {
//        System.out.println(customList.getMax());
//    }
//
//    private static void countGreaterThan(String[] tokens, CustomList<String> customList) {
//        System.out.println(customList.countGreaterThan(tokens[1]));
//    }
//
//    private static void swap(String[] tokens, CustomList<String> customList) {
//        customList.swap(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
//    }
//
//    private static void checkContains(String[] tokens, CustomList<String> customList) {
//        System.out.println(customList.contains(tokens[1]));
//    }
//
//    private static String remove(String[] tokens, CustomList<String> customList) {
//        int index = Integer.parseInt(tokens[1]);
//        return customList.remove(index);
//    }
//
//    private static void add(String[] tokens, CustomList<String> customList) {
//        String element = tokens[1];
//        customList.add(element);
//    }
}
