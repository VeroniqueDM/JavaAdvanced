package FilesAndStreams.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity){
        this.capacity=capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    public void add(Pet pet){
        if(capacity > this.data.size()){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet :
                this.data) {
            if (pet.getName().equals(name)) {
                this.data.remove(pet);
                return true;
            }
        }
        return false;

    }

    public Pet getPet(String name, String owner){
        for (Pet pet :
                this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
           }
        }
        return null;
    }
    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
      String res = ("The grooming salon has the following clients:\n");
        for (Pet pet :
                this.data) {
            res += pet.getName() + " " + pet.getOwner() + "\n";
        }
        return res;
    }
}
