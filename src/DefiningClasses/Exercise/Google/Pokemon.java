package DefiningClasses.Exercise.Google;

public class Pokemon {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return String.format("%s %s", name,type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
