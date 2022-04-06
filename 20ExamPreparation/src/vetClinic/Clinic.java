package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().contains(name));
    }

    public Pet getOldestPet() {
        return this.data.stream().max(Comparator.comparing(Pet::getAge)).orElse(null);
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        //The clinic has the following patients:
        //Bella Mia
        //Zak Jon
        StringBuilder stringBuilder = new StringBuilder("The clinic has the following patients:" +
                System.lineSeparator());
        for (Pet pet : data) {
            stringBuilder.append(pet.getName()).append(" ").append(pet.getOwner()).append("\n");
        }
        return stringBuilder.toString().trim();
    }
}
