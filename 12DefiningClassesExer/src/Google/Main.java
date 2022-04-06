package Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Persons> people = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String peopleName = tokens[0];

            if (!people.containsKey(peopleName)) { //here
                Persons person = new Persons();
                people.put(peopleName, person);
            }
            String typeClass = tokens[1];
            switch (typeClass) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    people.get(peopleName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemons = new Pokemon(pokemonName, pokemonType);
                    people.get(peopleName).getPokemons().add(pokemons);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    people.get(peopleName).getParents().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName, childBirthday);
                    people.get(peopleName).getChildren().add(child);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    people.get(peopleName).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }

        String printName = scanner.nextLine();
        System.out.println(printName);
        System.out.println(people.get(printName).toString());

    }
}
