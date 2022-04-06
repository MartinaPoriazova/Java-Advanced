package cafe;

public class Employee {
    //•	name: String
    //•	age: int
    //•	country: String
    private String name;
    private int age;
    private String country;

//    public Employee() {
//        this.name = name;
//        this.age = age;
//        this.country = country;
//    }

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        //"Employee: {name}, {age} from {country}"
        return String.format("Employee: %s, %d from %s", this.name, this.age, this.country);
    }
}
