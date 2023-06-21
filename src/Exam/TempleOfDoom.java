package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(toolsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(substancesStack::push);
        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()) {
            int tool = toolsQueue.peek();
            int substance = substancesStack.peek();
            int res = tool * substance;
            boolean passed = false;
            for (Integer challenge : challenges) {
                if (res == challenge) {
                    // CHANGE TO FORI IF IT DOESN'T WORK
                    toolsQueue.poll();
                    substancesStack.pop();
                    challenges.remove(challenge);
                    passed = true;
                    break;
                }
            }
            if (passed == false) {
                tool += 1;
                substance -= 1;
                toolsQueue.poll();
                if (tool > 0) {
                    toolsQueue.offer(tool);
                }
                substancesStack.pop();
                if (substance > 0) {
                    substancesStack.push(substance);
                }
            }
            if (challenges.isEmpty()) {
                break;
            }
        }
        if (challenges.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }
        if (!toolsQueue.isEmpty()) {
            System.out.print("Tools: ");
            System.out.println(toolsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!substancesStack.isEmpty()) {
            System.out.print("Substances: ");
            System.out.println(substancesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!challenges.isEmpty()) {
            System.out.print("Challenges: ");
            System.out.println(challenges.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
