package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        int sizeBeforeRemove = data.size();
        data.removeIf(pet -> pet.getName().equals(name));
        return sizeBeforeRemove != data.size();
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst().orElse(null);
        //Pet currentPet = this.data.stream()
        //        .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
        //        .findFirst().orElse(null);
        //
        //return currentPet;

    }

    public int getCount() {
        int count = data.size();
        return count;
    }

//o	" The grooming salon has the following clients:
//{name} {owner}
//{name} {owner}
//   (…)"

    public String getStatistics() {
        StringBuilder builder = new StringBuilder("The grooming salon has the following clients:"  + System.lineSeparator());

        for (Pet pet : data) {
            builder.append(pet.getName().toString());
            builder.append(" ");
            builder.append(pet.getOwner().toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
