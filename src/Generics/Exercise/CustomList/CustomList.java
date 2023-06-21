package Generics.Exercise.CustomList;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public CustomList() {
        this.data = new ArrayList<T>();
    }


    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index){
        if (index < 0 || index >= this.data.size()) {
            return null;
        }
        return this.data.remove(index);

    }

    public boolean contains(T element){
        return this.data.contains(element);
    }

    public void swap(int indexOne, int indexTwo){
        if (indexOne<0 || indexOne>=this.data.size() || indexTwo<0 || indexTwo>=this.data.size()){
            return;
        }
        T firstVal = this.data.get(indexOne);
        T secondVal = this.data.get(indexTwo);
        this.data.set(indexOne,secondVal);
        this.data.set(indexTwo,firstVal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T el : this.data) {
            sb.append(el).append(System.lineSeparator());

        }
        return String.valueOf(sb);
    }

    public int countGreaterThan(T element){
        List<T> filteredList = this.data.stream().filter(el -> el.compareTo(element)>0).collect(Collectors.toList());
        return filteredList.size();

    }

    public  T getMax(){
//        return this.data.stream().sorted().collect(Collectors.toList()).get(this.data.size()-1);
//        return this.data.stream().min(Comparator.reverseOrder()).orElse(null);
        return Collections.max(this.data);
    }

    public T getMin(){
//        return this.data.stream().sorted().findFirst().orElse(null);
        return Collections.min(this.data);
    }


//    public void forEach(Consumer<T> consumer) {
//        this.data.forEach(consumer::accept);
//    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                Iterator.super.forEachRemaining(action);
            }

            @Override
            public boolean hasNext() {
                return index< data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
