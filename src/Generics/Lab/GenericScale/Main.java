package Generics.Lab.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> integerScale = new Scale<>(8,5);
        System.out.println(integerScale.getHeavier());
    }

}
