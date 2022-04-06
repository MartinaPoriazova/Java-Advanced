package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream().filter(person -> person.getName().equals(name) &&
                person.getHometown().equals(hometown)).findFirst().orElse(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        // o	"The people in the hotel {name} are:
        StringBuilder stringBuilder = new StringBuilder(
                String.format("The people in the hotel %s are:", this.name) + System.lineSeparator());
        //Person {name}: {id}, Age: {age}, Hometown: {hometown}"
        for (Person person : roster) {
            stringBuilder.append(person.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
