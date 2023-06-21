package IteratorsAndComparators.Exercise.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<Person> compareByName = new TreeSet<>(new NameComparator());
        TreeSet<Person> compareByAge = new TreeSet<>(new AgeComparator());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            compareByAge.add(person);
            compareByName.add(person);
        }
        for (Person person : compareByName) {
            System.out.println(person);
        }
        for (Person person : compareByAge) {
            System.out.println(person);
        }

    }
}
