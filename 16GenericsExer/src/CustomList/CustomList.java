package CustomList;

import java.util.ArrayList;
import java.util.Collections;

public class CustomList<T extends Comparable<T>> {

    private ArrayList<T> elements;

    public CustomList() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T remove(int index) {
        return elements.remove(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public void swap(int first, int second) {
        Collections.swap(elements, first, second);
    }

//    public int countGreaterThan (T element) {
//        return (int)elements.stream().filter(e -> e.compareTo(element) > 0);
//    }

    public int size() {
        return elements.size();
    }

    public T get(int index) {
        return elements.get(index);
    }

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//
//    }

}
