package hotel;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hilton", 30);
        Person person = new Person("Mark", 11111, 41, "Sofia");
        System.out.println(person);
        //Person Mark: 11111, Age: 41, Hometown: Sofia
        hotel.add(person);
        System.out.println(hotel.getCount()); //1
        System.out.println(hotel.remove("Anna")); //false

        Person firstPerson = new Person("Alice", 22121, 18, "London");
        Person secondPerson= new Person("Lizzy", 31311, 24, "Varna");
        Person thirdPerson = new Person("Lucy", 54122, 31, "Birmingham");
        Person fourthPerson = new Person("Maria", 66611, 41, "Sofia");
        Person fifth = new Person("Maria", 66611, 41, "");
        hotel.add(firstPerson);
        hotel.add(secondPerson);
        hotel.add(thirdPerson);
        hotel.add(fourthPerson);
        Person personForGet = hotel.getPerson("Lucy", "Birmingham");
        Person personForGet1 = hotel.getPerson("Anna", "Burgas");
        System.out.println(personForGet); // Person Lucy: 54122, Age: 31, Hometown: Birmingham
        System.out.println(fifth); // null

        System.out.println(personForGet1); // null


        System.out.println(hotel.getCount()); // 5
        System.out.println(hotel.remove("Alice")); //true

        System.out.println(hotel.getStatistics());

    }
}
