package ExamPreparationOne;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> portionsStack = new ArrayDeque<>();
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(portionsStack::push);
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(staminaQueue::offer);
        Map<String, Integer> peaksMap = new LinkedHashMap<>();
        List<String> peaks = new LinkedList<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        List<String> conqueredPeaks = new LinkedList<>();
        peaksMap.put("Vihren", 80);
        peaksMap.put("Kutelo", 90);
        peaksMap.put("Banski Suhodol", 100);
        peaksMap.put("Polezhan", 60);
        peaksMap.put("Kamenitza", 70);
        boolean fiveInAWeek = false;
        for (int i = 0; i < 7; i++) {
            int portion = portionsStack.peek();
            int stamina = staminaQueue.peek();
            int res = portion+stamina;
            if (res>=peaksMap.get(peaks.get(0))){
                conqueredPeaks.add(peaks.get(0));
                peaks.remove(0);
                portionsStack.pop();
                staminaQueue.poll();
//                continue;
            } else {
                portionsStack.pop();
                staminaQueue.poll();
            }
            if (peaks.size()==0) {
                fiveInAWeek=true;
                break;
            }
        }
        if (fiveInAWeek) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if(conqueredPeaks.size()>0) {
            System.out.printf("Conquered peaks:%n%s", String.join(System.lineSeparator(), conqueredPeaks));
        }
    }
}
