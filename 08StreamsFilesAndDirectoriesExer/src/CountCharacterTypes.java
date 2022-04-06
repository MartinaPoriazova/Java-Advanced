import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountCharacterTypes {

    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "10. Exercise Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathString));

        int coutVowels = 0;
        int countConsonants = 0;
        int countPunctuations = 0;

        for (String line : allLines) {
            for (int index = 0; index < line.length(); index++) {
                char currentSymbol = line.charAt(index);
                if (currentSymbol == ' ') {
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'o' ||
                        currentSymbol == 'u' || currentSymbol == 'i') {
                    coutVowels++;
                } else if (currentSymbol == '?' || currentSymbol == '!' || currentSymbol == '.' ||
                        currentSymbol == ',') {
                    countPunctuations++;
                } else {
                    countConsonants++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_4.txt"));
        writer.write("Vowels: " + coutVowels);
        writer.newLine();
        writer.write("Consonants: " + countConsonants);
        writer.newLine();
        writer.write("Punctuation: " + countPunctuations);

        writer.close();

    }
}
