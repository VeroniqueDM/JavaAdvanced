package DefiningClasses.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(vowelsQueue::offer);

        ArrayDeque<String> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonantsStack::push);

        Map<String, Set<String>> words = new LinkedHashMap<>();
        words.put("pear", new HashSet<>());
        words.put("flour", new HashSet<>());
        words.put("pork", new HashSet<>());
        words.put("olive", new HashSet<>());

        while (!consonantsStack.isEmpty()) {
            String consonant = consonantsStack.pop();
            String vowel = vowelsQueue.poll();
            for (Map.Entry<String, Set<String>> word : words.entrySet()) {
                if (word.getKey().contains(consonant)) {
                    word.getValue().add(consonant);
                }
                if (word.getKey().contains(vowel)) {
                    word.getValue().add(vowel);
                }
            }
            vowelsQueue.offer(String.valueOf(vowel));
        }

        List<String> foundWords = new ArrayList<>();
        for (Map.Entry<String, Set<String>> word : words.entrySet()) {
            if (word.getKey().length() == word.getValue().size()) {
                foundWords.add(word.getKey());
            }
        }
        System.out.printf("Words found: %d%n",foundWords.size());
        foundWords.forEach(System.out::println);

    }
}
