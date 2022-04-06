package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (data.size() < capacity) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(present -> present.getName().contains(name));
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparing(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        return this.data.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        // Black bag contains:
        // Present Doll (0.40) for a girl
        // Present Train (2.00) for a boy
        StringBuilder str = new StringBuilder(String.format("%s bag contains:%n", this.getColor()));
        for (Present present : this.data) {
            str.append(present.toString()).append(System.lineSeparator());
        }
        return str.toString().trim();
    }
}
