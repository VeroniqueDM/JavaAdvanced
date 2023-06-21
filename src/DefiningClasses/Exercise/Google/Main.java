package DefiningClasses.Exercise.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Person> peopleMap = new HashMap<>();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String name = tokens[0];
            String infoAbout = tokens[1];
            switch (infoAbout) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    if (peopleMap.containsKey(name)) {
                        peopleMap.get(name).setCompany(company);
                    } else {
                        Person person = new Person(name);
                        person.setCompany(company);
                        peopleMap.put(name, person);
                    }
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    if (peopleMap.containsKey(name)) {
                        peopleMap.get(name).getPokemons().add(pokemon);
                    } else {
                        Person person = new Person(name);
                        person.getPokemons().add(pokemon);
                        peopleMap.put(name, person);
                    }
                    break;
                case "parents":
                    String parentName= tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName,parentBirthday);
                    if (peopleMap.containsKey(name)) {
                        peopleMap.get(name).getParents().add(parent);
                    }else {
                        Person person = new Person(name);
                        person.getParents().add(parent);
                        peopleMap.put(name,person);
                    }
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName,childBirthday);
                    if (peopleMap.containsKey(name)) {
                        peopleMap.get(name).getChildren().add(child);
                    } else {
                        Person person = new Person(name);
                        person.getChildren().add(child);
                        peopleMap.put(name,person);
                    }
                    break;
                case "car":
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(model,speed);
                    if (peopleMap.containsKey(name)) {
                        peopleMap.get(name).setCar(car);
                    }else {
                        Person person = new Person(name);
                        person.setCar(car);
                        peopleMap.put(name,person);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println(peopleMap.get(scanner.nextLine()));
    }
}
