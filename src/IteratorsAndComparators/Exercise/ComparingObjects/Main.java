package IteratorsAndComparators.Exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> peopleList = new LinkedList<>();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name, age, town);
            peopleList.add(person);
            input = scanner.nextLine();
        }
        int index = Integer.parseInt(scanner.nextLine());
        int countEqual = 0;
        if (peopleList.size() > index) {
            for (int i = 0; i < peopleList.size(); i++) {
                if (peopleList.get(i).compareTo(peopleList.get(index - 1)) == 0 ) {
                    countEqual++;
                }
            }
        }
        if (countEqual==0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", countEqual, peopleList.size() - countEqual, peopleList.size());

        }


    }
}
