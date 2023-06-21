package IteratorsAndComparators.Exercise.StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person personOne, Person personTwo) {
        if (personOne.getName().length() == personTwo.getName().length()) {
            char firstPersonChar = personOne.getName().toLowerCase().charAt(0);
            char secondPersonChar = personTwo.getName().toLowerCase().charAt(0);
            return Character.compare(firstPersonChar, secondPersonChar);
        }
        return Integer.compare(personOne.getName().length(), personTwo.getName().length());
    }
}
