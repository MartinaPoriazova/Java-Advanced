import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {

    public static void main(String[] args) throws IOException {
        String pathStringOne = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "10. Exercise Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt";
        Path pathFileOne = Path.of(pathStringOne);
        LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();
        List<String> allLineWords = Files.readAllLines(pathFileOne);
        allLineWords.forEach(line -> Arrays.stream(line.split("\\s+")).forEach(
                word -> wordsCount.put(word, 0)
        ));

        String pathStringTwo = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "10. Exercise Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt";
        Path pathFileTwo = Path.of(pathStringTwo);
        List<String> allLinesFileTwo = Files.readAllLines(pathFileTwo);

        for (String line : allLinesFileTwo) {
            String[] wordInLine = line.split("\\s+");
            Arrays.stream(wordInLine).forEach(word -> {
                if (word.contains(",")) {
                    word = word.replaceAll(",", "");
                }
                if (word.contains(".")) {
                    word = word.replaceAll(".", "");
                }
                if (wordsCount.containsKey(word)) {
                    int currentCount = wordsCount.get(word);
                    wordsCount.put(word, currentCount + 1);
                }
            });
        }
        wordsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println();

        PrintWriter writer = new PrintWriter("results.txt");

        wordsCount.forEach((key, value) -> writer.println(key + " - " + value));
        // wordsCount.entrySet().forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));

        writer.close();
    }
}
