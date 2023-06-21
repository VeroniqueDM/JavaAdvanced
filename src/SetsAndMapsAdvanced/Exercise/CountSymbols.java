package SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character,Integer> occurancesMap = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);

            if (occurancesMap.containsKey(character)){
                occurancesMap.put(character,occurancesMap.get(character) + 1);
            } else {
                occurancesMap.putIfAbsent(character,1);
            }
        }
        for (Map.Entry<Character, Integer> character : occurancesMap.entrySet()) {
            System.out.printf("%s: %d time/s%n",character.getKey(),character.getValue());
        }
    }
}
