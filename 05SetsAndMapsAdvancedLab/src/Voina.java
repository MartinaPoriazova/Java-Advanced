import java.util.*;
import java.util.stream.Collectors;

public class Voina {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds = 50;

        while (rounds-- > 0 && !firstPlayerDeck.isEmpty() && !secondPlayerDeck.isEmpty()) {
            Iterator<Integer> firstIterator = firstPlayerDeck.iterator();
            Iterator<Integer> secondIterator = secondPlayerDeck.iterator();

            int firstCard = firstIterator.next();
            firstIterator.remove();
            int secondCard = secondIterator.next();
            secondIterator.remove();

            if (firstCard > secondCard) {
                firstPlayerDeck.add(firstCard);
                firstPlayerDeck.add(secondCard);
            } else {
                secondPlayerDeck.add(firstCard);
                secondPlayerDeck.add(secondCard);
            }
            // rounds--
        }

        if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
