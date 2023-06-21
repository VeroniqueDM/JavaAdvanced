package IteratorsAndComparators.Lab.zoo;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tommy", 3, 4500);
        Cat cat2 = new Cat("Napo", 2, 5500);
        System.out.println(cat1.compareTo(cat2));
    }
}
