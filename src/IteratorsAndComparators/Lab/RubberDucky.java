package IteratorsAndComparators.Lab;

import java.util.*;

public class RubberDucky {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> timesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> countStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(timesQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(countStack::push);

        Map<String, Integer> ducksDict = new LinkedHashMap<>();
        ducksDict.put("Darth Vader Ducky", 0);
        ducksDict.put("Thor Ducky", 0);
        ducksDict.put("Big Blue Rubber Ducky", 0);
        ducksDict.put("Small Yellow Rubber Ducky", 0);
        while (!countStack.isEmpty() && !timesQueue.isEmpty()) {
            int time = timesQueue.poll();
            int count = countStack.pop();
            int res = time * count;
            if (res > 0 && res <= 60) {
                ducksDict.put("Darth Vader Ducky", ducksDict.get("Darth Vader Ducky") + 1);
            } else if (res > 60 && res <= 120) {
                ducksDict.put("Thor Ducky", ducksDict.get("Thor Ducky") + 1);
            } else if (res > 120 && res <= 180) {
                ducksDict.put("Big Blue Rubber Ducky", ducksDict.get("Big Blue Rubber Ducky") + 1);
            } else if (res > 180 && res <= 240) {
                ducksDict.put("Small Yellow Rubber Ducky", ducksDict.get("Small Yellow Rubber Ducky") + 1);
            } else {
                count -= 2;
                countStack.push(count);
                timesQueue.offer(time);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        for (Map.Entry<String, Integer> duckType : ducksDict.entrySet()) {
            System.out.printf("%s: %d%n",duckType.getKey(),duckType.getValue());
        }
    }
}
