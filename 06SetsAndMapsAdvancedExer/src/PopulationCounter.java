import java.util.*;

public class PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> countryPeople = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> populationStatistics = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            populationStatistics.putIfAbsent(country, new LinkedHashMap<>());
            populationStatistics.get(country).putIfAbsent(city, population);

            if (countryPeople.containsKey(country)) {
                countryPeople.put(country, countryPeople.get(country) + population);
            } else {
                countryPeople.put(country, population);
            }
//            countryPeople.compute(country, (k,v) ->
//                    v == null ? population : countryPeople.get(country) + population);

            input = scanner.nextLine();
        }
//.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))

        countryPeople.entrySet()
                .stream()
                .sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue()))
                .forEach(entry -> { //Bulgaria (total population: 1000000)
                    System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());
                    Map<String, Integer> cityCount = populationStatistics.get(entry.getKey());
                    cityCount.entrySet()
                            .stream()
                            .sorted((f1, f2) -> f2.getValue().compareTo(f1.getValue()))
                            .forEach(entry1 -> { //=>Sofia: 1000000
                                System.out.printf("=>%s: %d\n", entry1.getKey(), entry1.getValue());
                            });
                });
    }
}
