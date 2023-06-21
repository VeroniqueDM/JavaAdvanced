package DefiningClasses.Exercise.CompanyRoster;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> mapByDepartment = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] employeeInfo = scanner.nextLine().split("\\s+");
            Employee employee;
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            if (employeeInfo.length ==6) {
                String email = employeeInfo[4];
                int age = Integer.parseInt(employeeInfo[5]);
                employee = new Employee(name,salary,position,department,email,age);
            } else if (employeeInfo.length ==5){
                if (employeeInfo[4].contains("@")) {
                    String email = employeeInfo[4];
                    employee = new Employee(name,salary,position,department,email);
                } else {
                    int age = Integer.parseInt(employeeInfo[4]);
                    employee = new Employee(name,salary,position,department,age);
                }
            } else {
                employee = new Employee(name,salary,position,department);
            }
            if (mapByDepartment.containsKey(department)) {
                List<Employee> newList= mapByDepartment.get(department);
                newList.add(employee);
                mapByDepartment.put(department,newList);
            } else {
                List<Employee> newList= new ArrayList<>();
                newList.add(employee);
                mapByDepartment.put(department,newList);
            }

        }

        Map.Entry<String,List<Employee>> highestSalaryDept = mapByDepartment.entrySet().stream().sorted(Comparator
                .comparing((Map.Entry<String,List<Employee>> department)->
                        department.getValue().stream().mapToDouble(Employee::getSalary)
                                .average().getAsDouble(), Comparator.reverseOrder()))
                        .findFirst()
                                .orElse(null);
        System.out.printf("Highest Average Salary: %s%n",highestSalaryDept.getKey());

        highestSalaryDept.getValue().stream().sorted(   (e1,e2)-> Double.compare(e2.getSalary(),e1.getSalary())).forEach(System.out::println);

        //        String maxAvgDep = "";
//        double maxAvgSalary = 0;
//        for (Map.Entry<String, List<Employee>> department : mapByDepartment.entrySet()) {
//            double sumAvg = 0;
//            for (Employee employee : department.getValue()) {
//                sumAvg += employee.getSalary();
//            }
//            sumAvg = sumAvg/department.getValue().size();
//            if (sumAvg>maxAvgSalary) {
//                maxAvgSalary = sumAvg;
//                maxAvgDep = department.getKey();
//            }
//        }
//        System.out.printf("Highest Average Salary: %s%n",maxAvgDep);

//        for (Employee employee : mapByDepartment.get(maxAvgDep).stream().sorted((p1, p2) -> Double.compare(p2.getSalary(), p1.getSalary())).collect(Collectors.toList())) {
//            System.out.println(employee);
//        }
    }
}
