package Generics.Exercise.CustomList;

import java.util.Collections;

public class Sorter<T extends Comparable<T>> {
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        Collections.sort(customList.getData());

    }
}
