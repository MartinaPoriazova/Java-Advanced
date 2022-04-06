package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (data.size() < capacity) {
            data.add(rabbit);
        }
    }

    public int count() {
        return this.data.size();
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public boolean removeSpecies(String species) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(species));
    }

    public Rabbit sellRabbit(String name){
        Rabbit rabbitToReturn = null;

        for (Rabbit rabbit : data ) {
            if (rabbit.getName().equals(name)){
                rabbitToReturn = rabbit;
                rabbit.setAvailable(true);
                data.remove(rabbit);
                break;
            }
        }
        return rabbitToReturn;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> soldRabbits = data.stream().filter(r-> r.getSpecies().equals(species)).collect(Collectors.toList());
        data.removeIf(x-> x.getSpecies().equals(species));
        return soldRabbits;
    }

    public String report() {
        //Rabbits available at Wildness:
        //Rabbit (Blanc de Hotot): Fluffy
        //Rabbit (Brazilian): Marlin
        StringBuilder stringBuilder = new StringBuilder(String.format("Rabbits available at %s:\n", this.getName()));

        for (Rabbit rabbit : this.data) {
            stringBuilder.append(rabbit.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}