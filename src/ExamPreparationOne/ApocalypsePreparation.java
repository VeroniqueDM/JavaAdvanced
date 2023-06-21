package ExamPreparationOne;

import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> textileQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(textileQueue::offer);
        ArrayDeque<Integer> medsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(medsStack::push);
        Map<String, Integer> healingMap = new TreeMap<>();
        healingMap.put("Patch", 0);
        healingMap.put("Bandage", 0);
        healingMap.put("MedKit", 0);

        while (!textileQueue.isEmpty() && !medsStack.isEmpty()) {
            int textile = textileQueue.peek();
            int meds = medsStack.peek();
            int res = textile + meds;
            if (res == 30) {
                healingMap.put("Patch", healingMap.get("Patch") + 1);
                medsStack.pop();
                textileQueue.poll();
            } else if (res == 40) {
                healingMap.put("Bandage", healingMap.get("Bandage") + 1);
                medsStack.pop();
                textileQueue.poll();
            } else if (res == 100) {
                healingMap.put("MedKit", healingMap.get("MedKit") + 1);
                medsStack.pop();
                textileQueue.poll();
            } else if (res > 100) {
                int remainder = res - 100;
                healingMap.put("MedKit", healingMap.get("MedKit") + 1);
                medsStack.pop();
                textileQueue.poll();
                medsStack.push(medsStack.pop() + remainder);
            } else {
                textileQueue.poll();
                medsStack.pop();
                meds += 10;
                medsStack.push(meds);
            }
        }

        if (medsStack.isEmpty() && textileQueue.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (medsStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles are empty.");
        }
        healingMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e -> {
            if (e.getValue() != 0) {
                System.out.printf("%s - %d%n", e.getKey(), e.getValue());
            }
        });
        if (!textileQueue.isEmpty()){
            List<String> textilesLeft = new ArrayList<>();
            while (!textileQueue.isEmpty()) {
                textilesLeft.add(textileQueue.poll() + "");
            }
            System.out.println("Textiles left: " + String.join(", ", textilesLeft));
        }else if (!medsStack.isEmpty()){
            List<String> medicamentsLeft = new ArrayList<>();
            while (!medsStack.isEmpty()) {
                medicamentsLeft.add(medsStack.pop() + "");
            }
            System.out.println("Medicaments left: " + String.join(", ", medicamentsLeft));
        }
    }
}
