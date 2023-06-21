package SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String[] split = scanner.nextLine().split("\\s+");
//        Stream<String> stream = Arrays.stream(split);
//        Stream<Integer> integerStream = stream.map(Integer::parseInt);
//        Set<Integer> firstPlayer = integerStream.collect(Collectors.toSet());

//        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());
        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
            Iterator<Integer> firstIterator = firstPlayer.iterator();
            int firstCard = firstIterator.next();
            firstIterator.remove();

            Iterator<Integer> secondIterator = secondPlayer.iterator();
            int secondCard = secondIterator.next();
            secondIterator.remove();

            if (firstCard > secondCard) {
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (secondCard > firstCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
        }
        if (firstPlayer.size()<secondPlayer.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("First player win!");
        }

    }
}
