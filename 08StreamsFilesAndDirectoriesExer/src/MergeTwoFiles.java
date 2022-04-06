import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {

    public static void main(String[] args) throws IOException {
        String pathStringOne = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "10. Exercise Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt";
        Path pathFileOne = Path.of(pathStringOne);

        List<String> allLinesFileOne = Files.readAllLines(pathFileOne);

        String pathStringTwo = "C:\\Users\\Marti\\Desktop\\Advanced_Java\\" +
                "10. Exercise Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt";
        Path pathFileTwo = Path.of(pathStringTwo);

        List<String> allLinesFileTwo = Files.readAllLines(pathFileTwo);

        PrintWriter writer = new PrintWriter("outputMerge.txt");

        allLinesFileOne.forEach(line -> writer.println(line));
        allLinesFileTwo.forEach(writer::println);

        writer.close();
    }
}
