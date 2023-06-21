package IteratorsAndComparators.Exercise.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{

    private List<Integer> lake;


    public Lake(Integer... elements) {
        this.lake = List.of(elements);
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer>{
        private int index = 0;
        private boolean halfDone = false;

        @Override
        public boolean hasNext() {
            return index<lake.size();
        }

        @Override
        public Integer next() {
            Integer element = lake.get(index);
            index += 2;
            if (index >= lake.size() && !halfDone) {
                index = 1;
                halfDone = true;
            }
            return element;
        }
    }

}
