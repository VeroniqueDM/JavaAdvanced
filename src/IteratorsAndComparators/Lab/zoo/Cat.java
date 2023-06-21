package IteratorsAndComparators.Lab.zoo;

public class Cat implements Comparable<Cat>{
    private String name;
    private int age;
    private int weight;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public int compareTo(Cat o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age<o.age) {
            return -1;
        }
        return 0;

    }
}
