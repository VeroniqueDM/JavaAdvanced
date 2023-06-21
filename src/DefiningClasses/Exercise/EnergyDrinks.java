package DefiningClasses.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(caffeineStack::push);
        ArrayDeque<Integer> energyQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(energyQueue::offer);
        int currentSum = 0;
        int maxSum = 300;

        while (!energyQueue.isEmpty() && !caffeineStack.isEmpty()) {
            int milsCaffeine = caffeineStack.pop();
            int energyDrink = energyQueue.poll();
            int res = milsCaffeine*energyDrink;
            if (res+currentSum<=maxSum){
                currentSum +=res;
            } else {
                energyQueue.offer(energyDrink);
                currentSum = Math.max(currentSum - 30, 0);
            }
        }
        if (energyQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.print("Drinks left: ");
            for (int i = 0; i < energyQueue.size()-1; i++) {
                System.out.printf("%d, ", energyQueue.poll());
            }
            System.out.print(energyQueue.poll() + System.lineSeparator());
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.",currentSum);
    }
}
