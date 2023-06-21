package SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Set<String>> cardsMap = new LinkedHashMap<>();

        while (!command.equals("JOKER")) {
            String[] info = command.split(":");
            String name = info[0];
            Set<String> cards = Arrays.stream(info[1].strip().split(", ")).collect(Collectors.toSet());
            if (cardsMap.containsKey(name)) {
                cardsMap.get(name).addAll(cards);
            } else {
                cardsMap.put(name, cards);
            }
            command = scanner.nextLine();
        }
        Map<String, Integer> pointsMap = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> player : cardsMap.entrySet()) {
            int playerSum = 0;
            for (String card : cardsMap.get(player.getKey())) {
                String num = card.substring(0, card.length() - 1);
                char type = card.charAt(card.length() - 1);
                int numValue = 0;
                switch (num) {
                    case "J":
                        numValue = 11;
                        break;
                    case "Q":
                        numValue = 12;

                        break;
                    case "K":
                        numValue = 13;
                        break;
                    case "A":
                        numValue = 14;
                        break;
                    default:
                        numValue = Integer.parseInt(num);
                        break;
                }
                int typeValue = 0;
                switch (type) {
                    case 'S':
                        typeValue = 4;
                        break;
                    case 'H':
                        typeValue = 3;

                        break;
                    case 'D':
                        typeValue = 2;

                        break;
                    case 'C':
                        typeValue = 1;

                        break;
                }
                int res = numValue*typeValue;
                playerSum += res;

            }
            pointsMap.put(player.getKey(),playerSum);
        }
        pointsMap.forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
    }
}
