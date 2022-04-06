package hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String hometown = "n/a";

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    public String getName() {
        return name;
    }

    public String getHometown() {
        return hometown;
    }

    @Override //"Person {name}: {id}, Age: {age}, Hometown: {hometown}"
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s",
                name, id, age, hometown).trim();
    }
}
