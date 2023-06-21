package IteratorsAndComparators.Exercise.ComparingObjects;


public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person personTwo) {
        int res;
        if (this.getName().equals(personTwo.getName())) {
            if (this.getAge()==personTwo.getAge()) {
                res = this.getTown().compareTo(personTwo.getTown());
            } else {
                res = Integer.compare(this.getAge(),personTwo.getAge());
            }
        } else {
            res = this.getName().compareTo(personTwo.getName());
        }
        return res;
    }
}
