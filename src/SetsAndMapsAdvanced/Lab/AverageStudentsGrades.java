package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> schoolDiary = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] newEntry = scanner.nextLine().split(" ");
            String name = newEntry[0];
            double grade = Double.parseDouble(newEntry[1]);
            if (schoolDiary.containsKey(name)) {
                schoolDiary.get(name).add(grade);
            } else {
                List<Double> grades = new ArrayList<>();
                grades.add(grade);
                schoolDiary.put(name, grades);
            }
        }
        for (Map.Entry<String, List<Double>> name :
                schoolDiary.entrySet()) {
            double avg = findAverage(name.getValue());
            System.out.printf("%s -> ",name.getKey());
            for (int i = 0; i < name.getValue().size(); i++) {
                System.out.printf("%.2f ", name.getValue().get(i));
            }
            System.out.printf("(avg: %.2f)%n", avg);
        }

    }

//    private static String getGradesAsStr(List<Double> grades) {
//        String gradesAsStr = "";
//        for (int i = 0; i < grades.size(); i++) {
//            gradesAsStr += grades.get(i) + " ";
//        }
//        return gradesAsStr;
//    }

    private static double findAverage(List<Double> grades) {
        double sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        double avg = sum / grades.size();
        return avg;
    }
}
