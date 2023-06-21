package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Map<String, Double>>> dragonsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] dragonInfo = scanner.nextLine().split("\\s+");
            String type = dragonInfo[0];
            String name = dragonInfo[1];
            Map<String, Double> powers = new LinkedHashMap<>();
            if (dragonInfo[2].equals("null")) {
                powers.put("damage", 45.0);
            }else {
                powers.put("damage", Double.valueOf(dragonInfo[2]));
            }
            if (dragonInfo[3].equals("null")) {
                powers.put("health",250.0);
            }else {
                powers.put("health",Double.valueOf(dragonInfo[3]));
            }
            if (dragonInfo[4].equals("null")) {
                powers.put("armor",10.0);
            }else {
                powers.put("armor",Double.valueOf(dragonInfo[4]));
            }

            if (!dragonsMap.containsKey(type)) {
                Map<String, Map<String,Double>> names = new TreeMap<>();
                names.put(name,powers);
                dragonsMap.put(type,names);
            } else {
                dragonsMap.get(type).put(name,powers);
            }
        }
        Map<String,Map<String,Double>> avgMap = new HashMap<>();
        for (Map.Entry<String, Map<String, Map<String, Double>>> type : dragonsMap.entrySet()) {
            double avgDmg = 0;
            double avgHealth = 0;
            double avgArmor = 0;
            for (Map.Entry<String, Map<String, Double>> name : type.getValue().entrySet()) {
                for (Map.Entry<String, Double> power : name.getValue().entrySet()) {
                    switch (power.getKey()){
                        case "damage":
                            avgDmg += power.getValue();
                            break;
                        case "health":
                            avgHealth += power.getValue();
                            break;
                        case "armor":
                            avgArmor += power.getValue();
                            break;
                    }
                }
            }
            avgDmg/=type.getValue().size();
            avgHealth/=type.getValue().size();
            avgArmor/=type.getValue().size();
            Map<String,Double> averages= new HashMap<>();
            averages.put("damage", avgDmg);
            averages.put("health", avgHealth);
            averages.put("armor", avgArmor);
            avgMap.put(type.getKey(),averages);
        }
        for (Map.Entry<String, Map<String, Map<String, Double>>> type : dragonsMap.entrySet()) {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",type.getKey(),avgMap.get(type.getKey()).get("damage"),avgMap.get(type.getKey()).get("health"),avgMap.get(type.getKey()).get("armor"));
            for (Map.Entry<String, Map<String, Double>> name : type.getValue().entrySet()) {
                System.out.printf("-%s -> ",name.getKey());
                int ind = 0;
                for (Map.Entry<String, Double> power : name.getValue().entrySet()) {
                    if (ind==name.getValue().size()-1) {
                        System.out.printf("%s: %d%n" ,power.getKey(),power.getValue().intValue());
                    } else {
                        System.out.printf("%s: %d, " ,power.getKey(),power.getValue().intValue());
                    }
                    ind++;
                }
            }
        }
    }
}
