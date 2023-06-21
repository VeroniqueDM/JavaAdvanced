package Generics.Exercise.Box;

import java.util.List;
import java.util.stream.Collectors;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T data;

    @Override
    public String toString() {
        return String.format("%s: %s",this.data.getClass().getTypeName(),String.valueOf(this.data));
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Box(T data) {
        this.data = data;
    }

    public static void swapIndices(int indexOne, int indexTwo, List<Box> boxList){
        Box valueFirst = boxList.get(indexOne);
        boxList.set(indexOne,boxList.get(indexTwo));
        boxList.set(indexTwo,valueFirst);
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.data.compareTo(o.data);
    }

    public static <T extends Comparable<T>> int countGreaterElements(List<T> boxList, T element) {

        List<T> filteredList = boxList.stream().filter(el -> el.compareTo(element)>0).collect(Collectors.toList());
        return filteredList.size();
    }
}
