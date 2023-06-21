package IteratorsAndComparators.Lab;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //интерфейс:
        //1. дефинира поведение
        //2. подобно на клас, в който имаме методи без имплементация
        //3. не се инстанцира


        //Iterable -> може да се обхожда
        //Iterator -> инструмента, който обхожда
        //Comparable -> то може да се сравнява чрез метода compareTo
        //Comparator -> инструмент, чрез който можем да сравняваме

        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 5, 4, 7, 1));
        Iterator<Integer> iterator = numbers.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        Collections.sort(numbers); //числата да са подредени в нарастващ ред
        //sort
        //5 и 4
        //1. сравнява -> comparator -> < 0; == 0; > 0
        //2. проверка резултат от сравнение
        //< 0 -> второто > първото -> не променя местата
        // == 0 -> първото == второто -> не променя местата
        // > 0 -> първото > второто -> сменя местата на двата елемента

    }

    public static void printNames (String company, String... numbers) {
        //1. само един var args в метод
        //2. var args последни като параметър

    }
}
