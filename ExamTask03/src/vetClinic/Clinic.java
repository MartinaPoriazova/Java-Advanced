package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {

    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().contains(name));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet() {
        return this.data.stream().sorted(Comparator.comparingInt(Pet::getAge))
                .collect(Collectors.toList()).get(this.data.size() - 1);
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder("The clinic has the following patients:" + System.lineSeparator());
        for (Pet pet : data) {
            builder.append(pet.getName()).append(" ").
                    append(pet.getOwner()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}