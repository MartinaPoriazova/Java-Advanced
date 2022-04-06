package GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Box<T extends Comparable<T>> {

    List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = values.get(firstIndex);
        values.set(firstIndex, values.get(secondIndex));
        values.set(secondIndex, temp);
//        Collections.swap();
    }

    public int countOfGreaterItems(T element) {
        return (int) values.stream().filter(itemFromBox -> itemFromBox.compareTo(element) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T element : values) {
            stringBuilder.append(String.format("%s: %s", element.getClass().getName(), element.toString()))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
