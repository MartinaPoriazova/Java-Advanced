import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            // Peter: 2C, 4H, 9H, AS, QS
            String name = input.split(": ")[0];
            String cardsStr = input.split(": ")[1];
            String[] cardsArray = cardsStr.split(", ");
            Set<String> cards = new HashSet<>();
            Collections.addAll(cards, cardsArray);

            // името го има
            if (playersCards.containsKey(name)) {
                // в текущия сет
                Set<String> currentSet = playersCards.get(name);
                // добавяме новия ( с новите карти, които тегли)
                currentSet.addAll(cards);
                playersCards.put(name, currentSet);
                // името го няма
            } else {
                playersCards.put(name, cards);
            }
            input = scanner.nextLine();
        }
        playersCards.entrySet().forEach(entry -> {
            String name = entry.getKey();
            int points = getCardPoints(entry.getValue());
            System.out.printf("%s: %d\n", name, points);
        });

    }

    private static int getCardPoints(Set<String> cards) {
        Map<Character, Integer> pointMap = getCardValue();
        int cardsSum = 0;
        // На всяка карта точките
        for (String card : cards) {
            int points = 0;
            // - card = [number][type]
            // number - (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A -> number = points
            // type = (S, H, D, C)
            // points = points of number * points of type

            if (card.contains("10")) {
                char type = card.charAt(2);
                points = 10 * pointMap.get(type);
            } else {
                char number = card.charAt(0);
                char type = card.charAt(1);
                points = pointMap.get(number) * pointMap.get(type);
            }
            cardsSum += points;
        }
        // добавям ги към общата сума
        return cardsSum;
    }

    // метод с мап -
    private static Map<Character, Integer> getCardValue() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);
        return points;
    }
}
