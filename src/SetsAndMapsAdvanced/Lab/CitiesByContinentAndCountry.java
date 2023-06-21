package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> worldMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] entryInfo = scanner.nextLine().split(" ");
            String continent = entryInfo[0];
            String country = entryInfo[1];
            String city = entryInfo[2];
            addInfo(worldMap,continent,country,city);
        }
        printInfo(worldMap);
    }

    private static void printInfo(Map<String, Map<String, List<String>>> worldMap) {
        for (Map.Entry<String, Map<String, List<String>>> continent : worldMap.entrySet()) {
            System.out.println(continent.getKey()+ ":");
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("%s -> ",country.getKey());
                for (int i = 0; i < country.getValue().size(); i++) {
                    if (i==country.getValue().size()-1) {
                        System.out.printf("%s%n",country.getValue().get(i));
                    }else {
                        System.out.printf("%s, ", country.getValue().get(i));
                    }
                }
            }
        }
    }

    private static void addInfo(Map<String, Map<String, List<String>>> worldMap, String continent, String country,String city) {
        if (worldMap.containsKey(continent)) {
            if (worldMap.get(continent).containsKey(country)){
                worldMap.get(continent).get(country).add(city);
            } else {
                List<String> cities = new ArrayList<>();
                cities.add(city);
                worldMap.get(continent).put(country, cities);
            }
            ;
        } else {
            Map<String,List<String>> newContinent = new LinkedHashMap<>();
            List<String> cities = new ArrayList<>();
            cities.add(city);
            newContinent.put(country,cities);
            worldMap.put(continent,newContinent);
        }
    }
}
