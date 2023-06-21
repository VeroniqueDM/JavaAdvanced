package easterBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    public void addEgg(Egg egg){
        if (capacity > data.size()){
            data.add(egg);
        }
    }

    public String getMaterial() {
        return material;
    }

    public boolean removeEgg(String color){
        for (Egg egg : data) {
            if (egg.getColor().equals(color)){
                data.remove(egg);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg(){
        return data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    public Egg getEgg(String color){
        for (Egg egg : data) {
            if (egg.getColor().equals(color)){
                return egg;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:", getMaterial()));
        if (this.data.size()>0){
            sb.append(System.lineSeparator());
        }
        for (Egg egg : data) {
            sb.append(String.format("%s", egg));
        }
        return sb.toString();
    }
}
