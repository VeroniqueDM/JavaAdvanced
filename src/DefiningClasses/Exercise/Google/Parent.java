package DefiningClasses.Exercise.Google;

public class Parent {
    private String name;
    private String birthday;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
