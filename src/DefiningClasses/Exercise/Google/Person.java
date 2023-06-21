package DefiningClasses.Exercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator())
                .append((this.company!= null)?this.company:"");
//                .append(System.lineSeparator());
        sb.append("Car:").append(System.lineSeparator())
                .append((this.car!=null)? this.car : "");
        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : this.pokemons) {
            sb.append(pokemon).append(System.lineSeparator());
        }
        sb.append("Parents:").append(System.lineSeparator());
        for (Parent parent : this.parents) {
            sb.append(parent).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for (Child child : this.children) {
            sb.append(child).append(System.lineSeparator());
        }

        return String.valueOf(sb).trim();
    }

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }





}
