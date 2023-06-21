package DefiningClasses.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (capacity>this.employees.size()){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        Employee employee = this.employees.stream().filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
        if (employee != null) {
            this.employees.remove(employee);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
//        return this.employees.stream().max((e1,e2)-> Integer.compare(e1.getAge(),e2.getAge())).get();
    }

    public Employee getEmployee(String name) {
//        for (Employee employee : this.employees) {
//            if (employee.getName().equals(name)) {
//                return employee;
//            }
//
//        }
//        return null;

        return this.employees.stream().filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);


    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe" + this.name + ":");
        if (this.employees.size()>0){
            sb.append(System.lineSeparator());
        }
        this.employees.forEach(e -> sb.append(e).append(System.lineSeparator()));
        return sb.toString();
    }
}
