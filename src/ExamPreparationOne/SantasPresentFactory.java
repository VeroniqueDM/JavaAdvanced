package ExamPreparationOne;

import java.util.*;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materialsStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magicQueue::offer);
        Map<String, Integer> presentsDict = new TreeMap<>();
        presentsDict.put("Doll", 0);
        presentsDict.put("Wooden train", 0);
        presentsDict.put("Teddy bear", 0);
        presentsDict.put("Bicycle", 0);
        while (!magicQueue.isEmpty() && !materialsStack.isEmpty()) {
            int material = materialsStack.peek();
            int magic = magicQueue.peek();

            if (magic == 0 || material == 0) {
                if (material == 0) {
                    if (magic == 0) {
                        magicQueue.poll();
                        materialsStack.pop();
                        continue;
                    }
                    materialsStack.pop();
                    continue;
                } else {
                    magicQueue.poll();
                    continue;
                }
            }
            int res = magic * material;
            if (res == 150) {
                presentsDict.put("Doll", presentsDict.get("Doll") + 1);
                magicQueue.poll();
                materialsStack.pop();
            } else if (res == 250) {
                presentsDict.put("Wooden train", presentsDict.get("Wooden train") + 1);
                magicQueue.poll();
                materialsStack.pop();
            } else if (res == 300) {
                presentsDict.put("Teddy bear", presentsDict.get("Teddy bear") + 1);
                magicQueue.poll();
                materialsStack.pop();
            } else if (res == 400) {
                presentsDict.put("Bicycle", presentsDict.get("Bicycle") + 1);
                magicQueue.poll();
                materialsStack.pop();
            } else if (res < 0) {
                int sumValues = magic + material;
                materialsStack.pop();
                magicQueue.poll();
                materialsStack.push(sumValues);
            } else if (res > 0) {
                material += 15;
                materialsStack.pop();
                magicQueue.poll();
                materialsStack.push(material);
            }
        }
        boolean taskAchieved = (presentsDict.get("Doll") != 0 && presentsDict.get("Wooden train") != 0) || (presentsDict.get("Teddy bear") != 0 && presentsDict.get("Bicycle") != 0);
        if (taskAchieved) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materialsStack.isEmpty()) {
            System.out.printf("Materials left: ");
            while (materialsStack.size() != 1) {
                System.out.printf("%d, ", materialsStack.pop());
            }
            System.out.printf("%d%n", materialsStack.pop());
        }
        if (!magicQueue.isEmpty()) {
            System.out.printf("Magic left: ");
            while (magicQueue.size() != 1) {
                System.out.printf("%d, ", magicQueue.poll());
            }
            System.out.printf("%d%n", magicQueue.poll());
        }
        for (Map.Entry<String, Integer> present : presentsDict.entrySet()) {
            if (present.getValue() != 0) {
                System.out.printf("%s: %d%n", present.getKey(), present.getValue());
            }
        }
    }
}
