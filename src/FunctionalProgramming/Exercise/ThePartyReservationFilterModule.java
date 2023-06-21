package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> partyList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String instructions = scanner.nextLine();
        Map<String, Predicate<String>> predicatesMap = new HashMap<>();

        while (!instructions.equals("Print")){
            String[] tokens = instructions.split(";");

            String command = tokens[0];
            String type = tokens[1];
            String parameter = tokens[2];
            String name = type + parameter;


            if (command.equals("Add filter")) {
                Predicate<String> predicate;

                if (type.equals( "Starts with")){
                    predicate = s -> s.startsWith(parameter);
                    predicatesMap.putIfAbsent(name, predicate);
                } else if (type.equals("Ends with")) {
                    predicate = s -> s.endsWith(parameter);
                    predicatesMap.putIfAbsent(name, predicate);
                } else if (type.equals("Length")) {
                    int length = Integer.parseInt(parameter);
                    predicate = s -> s.length() == length;
                    predicatesMap.putIfAbsent(name, predicate);
                } else if (type.equals("Contains")) {
                    predicate = s -> s.contains(parameter);
                    predicatesMap.putIfAbsent(name, predicate);
                }
            } else if (command.equals("Remove filter")) {
                predicatesMap.remove(name);
                
            }

            instructions = scanner.nextLine();
        }
        for (String guest :
                partyList) {
            boolean isGoing = true;
            for (String key : predicatesMap.keySet()) {
                if(predicatesMap.get(key).test(guest)) {
                    isGoing=false;
                    break;
                }
            }
            if (isGoing){
                System.out.print(guest + " ");
            }
        }
    }
}
