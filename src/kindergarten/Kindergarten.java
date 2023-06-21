package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.getChildrenCount() == this.capacity) {
            return false;
        }
        this.registry.add(child);
        return true;
    }

    public boolean removeChild(String firstName) {
        return this.registry.remove(this.registry.stream().filter(child -> child.getFirstName().equals(firstName)).findFirst().orElse(null));
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return this.registry.stream().filter(child -> child.getFirstName().equals(firstName)).findFirst().orElse(null);
    }
    public String registryReport() {
        List<Child> sortedChildren = this.registry.stream()
                .sorted(Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append("Registered children in ").append(this.name).append(":");

        for (Child child : sortedChildren) {
            sb.append(System.lineSeparator()).append("--").append(System.lineSeparator());
            sb.append(child.toString());
        }

        return sb.toString().trim();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Child> getRegistry() {
        return registry;
    }

    public void setRegistry(List<Child> registry) {
        this.registry = registry;
    }
}
