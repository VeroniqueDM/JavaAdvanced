package ExamPreparationOne.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employeesList;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employeesList = new ArrayList<>();
    }
}
